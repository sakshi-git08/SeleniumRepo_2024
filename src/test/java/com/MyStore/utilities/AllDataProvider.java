package com.MyStore.utilities;

public class AllDataProvider {
    @org.testng.annotations.DataProvider(name = "LoginDP")
    public static String [][] LoginDP(){
        String fileName = System.getProperty("user.dir") + "\\testData\\MyStoreTestData.xlsx";

        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

        String data[][] = new String[ttlRows - 1][ttlColumns];
        for (int i = 1; i < ttlRows; i++){
            for (int j = 0; j < ttlColumns; j++){
                data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
            }
        }
        return data;
    }
}
