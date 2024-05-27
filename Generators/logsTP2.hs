{-# LANGUAGE DeriveGeneric #-}

import GHC.Generics (Generic)
import Data.Time (Day, fromGregorian, toGregorian)
import Test.QuickCheck
import Control.Monad (replicateM)
import Data.List (intercalate)

-- Definições de Tipos de Dados
data Acao = Comprar | Vender deriving (Show, Generic)
data TipoArtigo = Sapatilha | Mala | TShirt deriving (Show, Generic)
data Marca = Nike | Adidas | Puma deriving (Show, Generic)
data LogEntry = LogEntry
    { dataLog :: Day
    , idUtilizador :: Int
    , acao :: Acao
    , tipoArtigo :: Maybe TipoArtigo
    , detalhes :: String
    } deriving (Show, Generic)

instance Arbitrary Acao where
    arbitrary = elements [Comprar, Vender]

instance Arbitrary TipoArtigo where
    arbitrary = elements [Sapatilha, Mala, TShirt]

instance Arbitrary Marca where
    arbitrary = elements [Nike, Adidas, Puma]

arbitraryDay :: Gen Day
arbitraryDay = fromGregorian <$> choose (2000, 2100) <*> choose (1, 12) <*> choose (1, 28)

instance Arbitrary LogEntry where
    arbitrary = do
        dataLog <- arbitraryDay
        idUtilizador <- choose (1, 2)
        acao <- arbitrary
        case acao of
            Comprar -> do
                idArtigo <- elements ["A1", "A2", "A3", "A4", "A5"]
                return $ LogEntry dataLog idUtilizador Comprar Nothing idArtigo
            Vender -> do
                tipoArtigo <- arbitrary
                detalhes <- case tipoArtigo of
                    Sapatilha -> do
                        premium <- (arbitrary :: Gen Bool)
                        desc <- elements ["Como Novas", "Usadas", "Muito Usadas"]
                        marca <- (arbitrary :: Gen Marca)
                        preco <- (choose (0, 5000) :: Gen Int)
                        usado <- (arbitrary :: Gen Bool)
                        estado <- choose (0, 2) :: Gen Int
                        numDonos <- (choose (0,20) :: Gen Int)
                        transportadora <- choose (0, 2) :: Gen Int
                        tamanhoNumerico <- (choose(12,50) :: Gen Int)
                        atilhos <- (arbitrary :: Gen Bool)
                        cor <- elements ["Preto", "Branco", "Azul", "Vermelho", "Verde"]
                        ano <- (choose (2000, 2020) :: Gen Int)
                        return $ intercalate "," [show premium, desc, show marca, show preco, show usado, show estado, show numDonos, show transportadora, show tamanhoNumerico, show atilhos, cor, show ano]
                    Mala -> do
                        desc <- elements ["Como Novas", "Usadas", "Muito Usadas"] 
                        marca <- (arbitrary :: Gen Marca)
                        preco <- (choose (0,5000) :: Gen Int)
                        usado <- (arbitrary :: Gen Bool)
                        estado <- choose (0, 2) :: Gen Int
                        numDonos <- (choose(0,20) :: Gen Int)
                        transportadora <- choose (0, 2) :: Gen Int
                        dimensao <- choose (0, 2) :: Gen Int
                        material <- elements ["Pele", "Algodao", "Poliamida", "Poliester", "Nylon"]
                        ano <- (choose (2000, 2020) :: Gen Int)
                        premium <- (arbitrary :: Gen Bool)
                        return $ intercalate "," [desc, show marca, show preco, show usado, show estado, show numDonos, show transportadora, show dimensao, material, show ano, show premium]
                    TShirt -> do
                        desc <- elements ["Como Novas", "Usadas", "Muito Usadas"] 
                        marca <- (arbitrary :: Gen Marca)
                        preco <- (choose(0,5000) :: Gen Int)
                        usado <- (arbitrary :: Gen Bool)
                        estado <- choose (0, 2) :: Gen Int
                        numDonos <- (arbitrary :: Gen Int)
                        transportadora <- choose (0, 2) :: Gen Int
                        tamanho <- elements ["S", "M", "L", "XL"]
                        padrao <- elements ["liso", "riscas", "palmeiras"]
                        return $ intercalate "," [desc, show marca, show preco, show usado, show estado, show numDonos, show transportadora, tamanho, padrao]
                return $ LogEntry dataLog idUtilizador Vender (Just tipoArtigo) detalhes

formatLogEntry :: LogEntry -> String
formatLogEntry (LogEntry day idUtil Comprar Nothing detalhes) =
    let (year, month, dayOfMonth) = toGregorian day
    in show dayOfMonth ++ ":" ++ show month ++ ":" ++ show year ++ "," ++ show idUtil ++ "," ++ "Comprar" ++ "," ++ detalhes
formatLogEntry (LogEntry day idUtil Vender (Just tipoArtigo) detalhes) =
    let (year, month, dayOfMonth) = toGregorian day
    in show dayOfMonth ++ ":" ++ show month ++ ":" ++ show year ++ "," ++ show idUtil ++ "," ++ "Vender" ++ "," ++ show tipoArtigo ++ "," ++ detalhes

main :: IO ()
main = do
    logEntries <- generate $ vectorOf 10 (arbitrary :: Gen LogEntry)
    let logStrings = map formatLogEntry logEntries
    writeFile "logs.txt" (unlines logStrings)
