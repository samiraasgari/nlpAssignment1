﻿/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_file;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
   

/**
 *
 * @author samira
 */
public class file_mm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
  
          String path = "G:\\unii\\mergedTokens.en.txt";
          String path2 = "G:\\unii\\en.tokens.en.txt";
          
           int numL =0;
           int numL2 =0;
           int Num =0;
           
           String matn ;
           String matn2 ;
           boolean c = false;
        //  
        
        FileReader fr = new FileReader (path);
        BufferedReader textReader =new BufferedReader (fr);
        
        FileReader fr2 = new FileReader (path2);
        BufferedReader textReader2 =new BufferedReader (fr2);
        //
         numL = readLines( path ); //تعداد خطوط متن ورودی
          numL2 = readLines( path2 );// تعداد خطوط لغت نامه
       //  
       System.out.println( "tedade khotoote matn :" + numL ) ;
       System.out.println( "vocab :" + numL2 ) ;
       
       //
       
        String[ ] textData = new String[numL];
        int i;
        String[ ] textData2 = new String[numL2];
        int j;
        String[ ] [ ] splitSentence = new String[numL][85];
        
        //
        for (i=0; i < numL; i++) {
        textData[ i ] = textReader.readLine();
        //System.out.println( textData[ i ] ) ;
        
        }
         textReader.close( );
         //
        for (j=0; j < numL2; j++) {
        textData2[ j] = textReader2.readLine();
        //System.out.println( textData2[ j ] ) ;
       
        }
         textReader2.close( );
         
         ////////
             int lenght_dealet=0;
             int count=0;
         for(i=0 ; i< numL ;i++){
              matn=textData[i];
              String templat = matn;
              
            for(j=0 ; j<numL2 ; j++){
                    matn2=textData2[j];
                    c = templat.equalsIgnoreCase(matn2);
                    
                if (c == false && j==numL2-1){
                    if(templat.length()>0){
                    templat=templat.substring(0, templat.length()-1);
                    count++;
                    j=-1;
                    }
                    else if(templat.length()==0) templat="error";
                    }
                else if( c== true)
                {
                    
                    splitSentence[i][Num ]=templat;
                    Num ++;
                     
                     lenght_dealet=matn.length()-count;
                     templat=matn.substring(lenght_dealet);
                     
                     j=-1;
                     count=0;
                      
                   //  matn=matn.substring(i, numL2);

                }
              //templat = matn;
            
                  
              
              }
        Num =0;
         }
         //////////  چاپ خروجی
    for (i=0; i<numL; i++) {
       System.out.print( i+")"+textData[ i ]+"     ");
                 for(j=0 ;  j<20  ;j++ ){
                       if(splitSentence[i][j]==null)
                           break;
                       else
                       System.out.print(splitSentence[i][j ]+" ");
                 
                 }
                System.out.println();
                 
             }
    /////// نوشتن خروجی نهایی در فایل
    try {
            FileOutputStream fstream = new FileOutputStream("G:\\unii\\6\\NLP\\92463228_Assignment1_EN");

            DataOutputStream out = new DataOutputStream(fstream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            for (i=0; i<numL; i++) {
                bw.write(i+")"+textData[ i ]+"     ");
                 for(j=0 ;  j<20  ;j++ ){
                       if(splitSentence[i][j]==null)
                           break;
                       else
                       bw.write(splitSentence[i][j ]+" ");
                 
                 }
                 bw.newLine();
                 
             }
            

            bw.flush();
            out.close();
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


        
    }

    /////read line : یافتن تعداد خطوط فایل
    public static int readLines (String path) throws IOException{
       FileReader file_to_read = new FileReader (path);
       BufferedReader bf =new BufferedReader (file_to_read);
       
       String aLine ;
       int numberOfLines = 0;
       
       while ( ( aLine = bf.readLine( ) ) != null ) {
 
             numberOfLines++;
       }
             bf.close();
             return numberOfLines;
 
}
    }   
    

