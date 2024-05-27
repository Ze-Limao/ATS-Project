{-# LANGUAGE DeriveGeneric #-}

import GHC.Generics (Generic)
import Data.Time (Day, fromGregorian)
import Test.QuickCheck
import Data.Map (Map)
import qualified Data.Map as Map


-- Transportadoras
data NomeTransportadora = CTT | DHL | INPOST 
    deriving (Show, Bounded, Enum)

-- Encomenda
data DimensaoEmbalagem = GRANDE | MEDIO | PEQUENO 
    deriving (Show, Bounded, Enum)
data EstadoEncomenda = PENDENTE | FINALIZADA | EXPEDIDA | DEVOLVIDA 
    deriving (Show, Bounded, Enum)

-- Artigo
data Estado = NOVO | USADO 
    deriving (Show, Bounded, Enum)
data Avaliacao = IMPECAVEL | BOM | SATISFATORIO 
    deriving (Show, Bounded, Enum)

-- Malas e Sapatilhas
data TiposMalasSapatilhas = NORMAL | PREMIUM 
    deriving (Show, Bounded, Enum)

-- Tshirts
data Tamanho = S | M | L | XL 
    deriving (Show, Bounded, Enum)
data Padrao = LISO | RISCAS | PALMEIRAS 
    deriving (Show, Bounded, Enum)

arbitraryDay :: Gen Day
arbitraryDay = fromGregorian <$> choose (1900, 2100) <*> choose (1, 12) <*> choose (1, 28)

data Malas = Malas
    { artigoBase :: Artigo
    , tipoMala :: TiposMalasSapatilhas
    , dim :: Float
    , material :: String
    , anoDaColecao :: Int
    } deriving Show

data Sapatilhas = Sapatilhas
    { artigoBase1 :: Artigo
    , tamanhoNumerico :: Int
    , atilhos :: Bool
    , cor :: String
    , dataLancamento :: Day
    , tiposMalasSapatilhas :: TiposMalasSapatilhas
    } deriving Show

data TShirt = TShirt
    { artigoBase2 :: Artigo
    , tamanho0 :: Tamanho
    , padrao :: Padrao
    } deriving Show

data Artigo = Artigo
    { artigoId :: Int
    , tipo :: String
    , estado0 :: Estado
    , numeroDonos :: Int
    , avaliacao :: Avaliacao
    , descricao :: String
    , marca :: String
    , codigo :: String
    , precoBase :: Double
    , correcaoPreco :: Double
    , transportadora :: NomeTransportadora
    } deriving Show

data Produto = ProdutoMalas Malas | ProdutoSapatilhas Sapatilhas | ProdutoTShirt TShirt
    deriving Show

--MALAS
instance Arbitrary TiposMalasSapatilhas where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary Malas where
    arbitrary = do
        artigoBase <- arbitrary
        tipoMala <- arbitrary
        dim <- arbitrary
        material <- arbitrary
        anoDaColecao <- choose (2000, 2024)
        return $ Malas artigoBase tipoMala dim material anoDaColecao

instance Arbitrary Sapatilhas where
    arbitrary = do
        artigoBase <- arbitrary
        tamanhoNumerico <- choose (35, 45)
        atilhos <- arbitrary
        cor <- arbitrary
        dataLancamento <- arbitraryDay
        tiposMalasSapatilhas <- arbitrary
        return $ Sapatilhas artigoBase tamanhoNumerico atilhos cor dataLancamento tiposMalasSapatilhas

--TSHIRT
instance Arbitrary Tamanho where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary Padrao where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary TShirt where
    arbitrary = do
        artigoBase <- arbitrary
        tamanho <- arbitrary
        padrao <- arbitrary
        return $ TShirt artigoBase tamanho padrao

--ARTIGO
instance Arbitrary Estado where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary Avaliacao where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary Artigo where
    arbitrary = do
        artigoId <- arbitrary
        tipo <- arbitrary
        estado <- arbitrary
        numeroDonos <- choose (0, 5)
        avaliacao <- arbitrary
        descricao <- arbitrary
        marca <- arbitrary
        codigo <- arbitrary
        precoBase <- arbitrary
        correcaoPreco <- arbitrary
        transportadora <- arbitrary
        return $ Artigo artigoId tipo estado numeroDonos avaliacao descricao marca codigo precoBase correcaoPreco transportadora

--PRODUTO
instance Arbitrary Produto where
    arbitrary = oneof [ ProdutoMalas <$> arbitrary
                      , ProdutoSapatilhas <$> arbitrary
                      , ProdutoTShirt <$> arbitrary
                      ]

--ENCOMENDA
data Encomenda = Encomenda
    { dono :: String
    , id :: Int
    , artigos :: [Produto]
    , embalagem :: DimensaoEmbalagem
    , precoFinal :: Double
    , custosExpedicao :: Double
    , estado :: EstadoEncomenda
    , dataCriacao :: Day
    , tamanho :: Int
    , prazoLimite :: Day
    , vendedores :: Map Int String
    } deriving Show

instance Arbitrary DimensaoEmbalagem where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary EstadoEncomenda where
    arbitrary = arbitraryBoundedEnum

instance Arbitrary Day where
    arbitrary = arbitraryDay

instance Arbitrary Encomenda where
    arbitrary = do
        dono <- genNome
        id <- arbitrary
        artigos <- resize 10 arbitrary
        embalagem <- arbitrary
        precoFinal <- arbitrary
        custosExpedicao <- arbitrary
        estado <- arbitrary
        dataCriacao <- arbitrary
        tamanho <- choose (1, 100)
        prazoLimite <- arbitrary
        vendedores <- resize 10 arbitrary
        return $ Encomenda dono id artigos embalagem precoFinal custosExpedicao estado dataCriacao tamanho prazoLimite vendedores

-- Transportadoras
instance Arbitrary NomeTransportadora where
    arbitrary = arbitraryBoundedEnum

data Transportadoras = Transportadoras
    { nome :: NomeTransportadora
    , imposto :: Double
    , lucro :: Double
    , premium :: Bool
    , volFaturacao :: Double
    , formula :: Int
    } deriving (Show, Generic)

instance Arbitrary Transportadoras where
    arbitrary = do
        nome <- arbitrary
        imposto <- choose (0, 50)
        lucro <- choose (0, 100)
        premium <- arbitrary
        volFaturacao <- choose (0, 1000)
        formula <- arbitrary
        return $ Transportadoras nome imposto lucro premium volFaturacao formula

-- Utilizador
data Utilizador = Utilizador
    { id_ :: Int
    , email :: String
    , password :: String
    , nome_ :: String
    , morada :: String
    , nif :: Int
    , compras :: [Artigo]
    , porVender :: [Artigo]
    , vendas :: [Artigo]
    , faturacao :: Map Day Double
    } deriving (Show, Generic)

instance Arbitrary Utilizador where
    arbitrary = do
        id_ <- choose (1, 1000)
        email <- elements ["user1@example.com", "user2@example.com", "user3@example.com"]
        password <- elements ["password123", "mysecurepassword", "123456"]
        nome_ <- elements ["John Doe", "Jane Smith", "Alice Johnson"]
        morada <- elements ["123 Main St", "456 Elm St", "789 Oak St"]
        nif <- choose (100000000, 999999999)
        compras <- resize 5 arbitrary
        porVender <- resize 5 arbitrary
        vendas <- resize 5 arbitrary
        faturacao <- resize 5 arbitrary
        return $ Utilizador id_ email password nome_ morada nif compras porVender vendas faturacao

-- Vintage
data Vintage = Vintage
    { sessaoAtual :: String
    , utilizadores :: Map String Utilizador
    , encomendas :: [Encomenda]
    , transportadoras :: Map String Transportadoras
    , dataPrograma :: Day
    } deriving (Show, Generic)

instance Arbitrary Vintage where
    arbitrary = do
        sessaoAtual <- elements ["sessao1", "sessao2", "sessao3"]
        utilizadores <- resize 2 arbitrary
        encomendas <- resize 1 arbitrary
        transportadoras <- resize 1 arbitrary
        dataPrograma <- arbitrary
        return $ Vintage sessaoAtual utilizadores encomendas transportadoras dataPrograma

genNome :: Gen String
genNome = elements ["John Doe", "Jane Smith", "Alice Johnson", "Bob Brown"]

-- Main function for testing
main :: IO ()
main = do
    --sample (arbitrary :: Gen Encomenda)
    --sample (arbitrary :: Gen Transportadoras)
    --sample (arbitrary :: Gen Utilizador)
    sample (arbitrary :: Gen Vintage)