package Aston.lesson6;

public class Main {
    public static void main(String[] args) {
        AppData data = new AppData();
        data.setHeader(new String[] {"Value 1", "Value 2", "Value 3"});
        data.setData(new int[][] {{100, 210, 123}, {300, 400, 700}});

        String filePath = "test.csv";
        data.save(filePath);

        AppData loadedData = new AppData();
        loadedData.load(filePath);

        System.out.println(String.join(";", loadedData.getHeader()));
        int[][] loadedDataValues = loadedData.getData();
        for (int[] row : loadedDataValues) {
            for (int value : row) {
                System.out.print(value + "; ");
            }
            System.out.println();
        }
    }
}