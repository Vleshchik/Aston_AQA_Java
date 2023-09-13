package Aston.lesson6;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void save(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write(String.join(";", header));
            writer.newLine();

            for (int[] row : data) {
                StringBuilder rowData = new StringBuilder();
                for (int value : row) {
                    rowData.append(value).append(";");
                }
                rowData.deleteCharAt(rowData.length() - 1);
                writer.write(rowData.toString());
                writer.newLine();
            }

            System.out.println("Данные успешно сохранены в CSV-файле.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в CSV-файле: " + e.getMessage());
        }
    }

    public void load(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных из CSV-файла: " + e.getMessage());
            return;
        }

        String[] header = lines.get(0).split(";");
        setHeader(header);

        int[][] data = new int[lines.size() - 1][header.length];
        for (int i = 1; i < lines.size(); i++) {
            String[] rowData = lines.get(i).split(";");
            for (int j = 0; j < rowData.length; j++) {
                data[i - 1][j] = Integer.parseInt(rowData[j]);
            }
        }
        setData(data);

        System.out.println("Данные успешно загружены из CSV-файла.");
    }
}