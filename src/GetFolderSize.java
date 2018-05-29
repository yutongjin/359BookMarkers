
import java.io.File;
import java.text.DecimalFormat;

import java.text.NumberFormat;

public class GetFolderSize {

    int totalFolder = 0;

    int totalFile = 0;


    public static void calculate(){
        try {

            GetFolderSize size = new GetFolderSize();

             long fileSizeByte = size.getFileSize(new File(Main.folder));
            System.out.println();
             // System.out.println("Folder Size: " + fileSizeByte + " Bytes");

            System.out.println("Total Number of types: "+ size.getTotalFolder());

            System.out.println("Total Number of Questions: " + size.getTotalFile());

        } catch (Exception e) {}

    }
    public long getFileSize(File folder) {

        totalFolder++;

        long foldersize = 0;

        File[] filelist = folder.listFiles();

        for (int i = 0; i < filelist.length; i++) {

            if (filelist[i].isDirectory()) {

                foldersize += getFileSize(filelist[i]);

            } else {

                totalFile++;

                foldersize += filelist[i].length();

            }


        }
        if(!folder.getName().equals("src")) {
            System.out.printf("%-20s", "Type : " + folder.getName());
            System.out.print("  Number :" + filelist.length + "\n");
        }

        return foldersize;

    }

    public int getTotalFolder() {

        return totalFolder;

    }

    public int getTotalFile() {

        return totalFile;

    }

}

