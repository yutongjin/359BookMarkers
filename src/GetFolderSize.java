
import java.io.File;
import java.text.DecimalFormat;

import java.text.NumberFormat;

public class GetFolderSize {

    int totalFolder = 0;

    int totalFile = 0;
    int javaFile = 0;
    int interfaceFile = 0;

    public static void calculate(){
        try {

            GetFolderSize size = new GetFolderSize();
           // File file=new File(Main.folder);

         //   String fileName=file.getName();
//
          //  String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());

            //System.out.println(//fileTyle);
          //  if(!file.isDirectory())
           // System.out.println(file.getName().substring(file.getName().lastIndexOf("."),file.getName().length()));
       //     else System.out.println("dir");
             long fileSizeByte = size.getFileSize(new File(Main.folder));
             System.out.println();
             // System.out.println("Folder Size: " + fileSizeByte + " Bytes");

            System.out.println("Total Number of types: "+ size.getTotalFolder());

            System.out.println("Total Number of Questions: " + (size.getTotalFile()-4));

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
                for (File file : filelist) {
                    if (file.getName().substring(file.getName().lastIndexOf("."), file.getName().length()).equals("java"))
                        javaFile++;
                }


            }
            if (!folder.getName().equals("src") && !folder.getName().equals("problems")) {
                System.out.printf("%-20s", "Type : " + folder.getName());
                System.out.print("  Number :" + filelist.length + "\n");
            }
        }
            return foldersize;

        }

        public int getTotalFolder () {

            return totalFolder;

        }

        public int getTotalFile () {

            return totalFile;

        }

    }

