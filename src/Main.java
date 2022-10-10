import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        File main = new File("C://Games//src//main");
        if (main.mkdirs()) {
            sb.append("Каталог создан");
            sb.append("\n");
        } else {
            sb.append("Каталог не создан");
            sb.append("\n");
        }

        File test = new File("C://Games//src//test");
        if (test.mkdir()) {
            sb.append("Каталог создан");
            sb.append("\n");
        } else {
            sb.append("Каталог не создан");
            sb.append("\n");
        }

        String[] gameDirs = {"res", "savegames", "temp"};
        String[] resDirs = {"drawables", "vectors", "icons"};
        String[] mainFiles = {"Main.java", "Utils.java"};
        sb.append(CreateDir("C://Games//", gameDirs));
        sb.append(CreateDir("C://Games//res//", resDirs));
        sb.append(CreateFile("C://Games//src//main//", mainFiles));

        File temp = new File("C://Games//temp//temp.txt");
        try {
            if (temp.createNewFile()) {
                sb.append("Фаил " + temp + " был создан");
                sb.append("\n");
            }
        } catch (IOException ex) {
            sb.append(ex.getMessage());
        }

        String forTemp = sb.toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"))) {
            bw.write(forTemp);
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public static String CreateDir(String dir, String[] names) {
        StringBuilder sbDir = new StringBuilder();
        for (String name : names) {
            String dirName = dir + name;
            File file = new File(dirName);
            if (file.mkdir()) {
                sbDir.append("Каталог " + dirName + " создан");
                sbDir.append("\n");
            } else {
                sbDir.append("Каталог " + dirName + " не создан");
                sbDir.append("\n");
            }
        }
        String sbDirToString = sbDir.toString();
        return sbDirToString;

    }

    public static String CreateFile(String dir, String[] names) throws IOException {
        StringBuilder sbFile = new StringBuilder();
        for (String name : names) {
            String fileName = dir + name;
            File file = new File(fileName);
            try {
                if (file.createNewFile()) {
                    sbFile.append("Фаил " + fileName + " был создан");
                    sbFile.append("\n");
                }
            } catch (IOException ex) {
                sbFile.append(ex.getMessage());
            }
        }
        String sbFileToString = sbFile.toString();
        return sbFileToString;
    }

}
