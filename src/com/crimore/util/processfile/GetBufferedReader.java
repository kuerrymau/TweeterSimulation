package com.crimore.util.processfile;

import java.io.*;

/**
 * Created by cchingwenje on 2015-08-23.
 */

@Deprecated
public class GetBufferedReader {
    /**
     *
     * @param file
     * @param br
     * @return
     * @throws FileNotFoundException
     */
    public static BufferedReader getBufferedReader(File file, BufferedReader br) throws FileNotFoundException {
        System.out.println("in getBufferedReader()");
//        System.out.println("file.getName()" + file.getName());
        try {
            FileInputStream fis = new FileInputStream(file); // FIXME get file path
            DataInputStream dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return br;
    }
}
