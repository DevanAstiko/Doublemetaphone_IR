package fix_stki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jojo-pc
 */
public class fungsi {
//    char arr[];
    public static  String konverterPrimary (String kata){
      
//        arr= kata.toCharArray();
        
        String array[]=toStringArray(kata);
        String array_hasil[]=toStringArray(kata);
        
        

        for (int i = 0; i < array.length; i++) {
            if (isVokal(array[i])||compareString(array[i], "y")) { //jika aiueoy 
                if (i==0) {
                    array_hasil[i]="A";
                } else {
                    array_hasil[i]="";
                }
            }
            else if (compareString(array[i], "b")){ //jika b
                if ((i-1>=0)&&(i==(array.length-1))) {
                    if (compareString(array[i-1], "m")) {
                        array_hasil[i]="P";
                    }
                } else {
                    array_hasil[i]="B";
                }
            }
            else if (compareString(array[i], "c")){ //jika c
                boolean isDone = false;
                if ((i-1>=0)&&(i+1<=array.length-1)) { //jika dalam -sch-
                    if ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "H"))) {
                        array_hasil[i]="K";
                        isDone=true;
                    }
                }
                if (array.length>=6) { //jika dalam ORCHES
                    if ((i-2>=0)&&(i+3<=array.length-1)) {
                        if (((compareString(array[i-2], "O"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "E"))
                                &&(compareString(array[i+3], "S"))
                                ) || ((compareString(array[i-2], "A"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "I"))
                                &&(compareString(array[i+3], "T"))
                                ) || ((compareString(array[i-2], "O"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "I"))
                                &&(compareString(array[i+3], "D"))
                                )
                                ){
                            array_hasil[i]="K";
                            isDone=true;
                        }
                    }
                }
                if ((i-1>=0)) { //jika dalam mc
                    if ((compareString(array[i-1], "M"))){
                        array_hasil[i]="K"; isDone=true; 
                    }
                }
                if ((i+1<=array.length-1)) { //jika dalam ck cg cq
                    if ((compareString(array[i+1], "K"))
                            ||(compareString(array[i+1], "G"))
                            ||(compareString(array[i+1], "Q"))){
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+5<=array.length-1) { //jika diikuti -harac -haris
                    if (
                            ((compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "R"))&&(compareString(array[i+4], "A"))
                            &&(compareString(array[i+5], "C"))) ||
                            ((compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "R"))&&(compareString(array[i+4], "I"))
                            &&(compareString(array[i+5], "S")))
                            ) {
                            array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika sebelum L,R,N,M,B,H,F,V,W
                    if (
                            (compareString(array[i+1], "L")) ||
                            (compareString(array[i+1], "R")) ||
                            (compareString(array[i+1], "N")) ||
                            (compareString(array[i+1], "M")) ||
                            (compareString(array[i+1], "B")) ||
                            (compareString(array[i+1], "H")) ||
                            (compareString(array[i+1], "F")) ||
                            (compareString(array[i+1], "V")) ||
                            (compareString(array[i+1], "W"))
                            ){
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+3<=array.length-1) { //jika di dalam chae
                    if (
                            (compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "E"))
                            ) {
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+i<=array.length-1) { //jika didalam -ci- -ce- -cy-
                    if (
                            (compareString(array[i+1], "I")) ||
                            (compareString(array[i+1], "E")) ||
                            (compareString(array[i+1], "Y"))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+5<=array.length-1) { //jika didalam -caesar-
                    if (
                            ((compareString(array[i+1], "A"))&&(compareString(array[i+2], "E"))
                            &&(compareString(array[i+3], "S"))&&(compareString(array[i+4], "A"))
                            &&(compareString(array[i+5], "R")))
                            ) {
                            array_hasil[i]="S"; isDone=true;
                    }
                }
                if ((i-1>=0)&&(i+1<=array.length-1)) { //jika dalam -sci- -scy- sce
                    if (
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "I"))) ||
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "Y"))) ||
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "E")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika di dalam cz
                    if ((compareString(array[i+1], "Z"))) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+3<=array.length-1) { //jika diikuti dengan -CIA -CIE -CIO
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "A"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "E"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "O")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika didalam cc
                    if ((compareString(array[i+1], "C"))) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i-1>=0) { //jika didalam cc
                    if ((compareString(array[i-1], "C"))) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if ((i-1>=0)&&(i+3<=array.length-1)) { //jika u"c"cee u"c"ces
                    if (
                            ((compareString(array[i-1], "U"))&&(compareString(array[i+1], "C"))
                            &&(compareString(array[i+2], "E"))&&(compareString(array[i+3], "E"))) ||
                            ((compareString(array[i-1], "U"))&&(compareString(array[i+1], "C"))
                            &&(compareString(array[i+2], "E"))&&(compareString(array[i+3], "S")))
                            ) {
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if ((i-2>=0)&&(i+2<=array.length-1)) { //jika uc"c"ee uc"c"es
                    if (
                            ((compareString(array[i-2], "U"))&&(compareString(array[i-1], "C"))
                            &&(compareString(array[i+1], "E"))&&(compareString(array[i+2], "E"))) ||
                            ((compareString(array[i-2], "U"))&&(compareString(array[i-1], "C"))
                            &&(compareString(array[i+1], "E"))&&(compareString(array[i+2], "S")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if(!isDone){
                    array_hasil[i]="K";
                }
            } //end of C
            else if(compareString(array[i], "D")){ //d
                if(i+1<array.length){     
                    if (compareString(array[i+1],"G")) {
                    
                        if(i+2<array.length){
                            if(compareString(array[i+2], "E")||compareString(array[i+2], "I")
                                ||compareString(array[i+2], "Y")){
                                    array_hasil[i]="J";    
                            }
                        }
                    else{
                        array_hasil[i]="TK";//harusnya TK
                    array_hasil[i]=array_hasil[i].toUpperCase();
                    }
                 }
                   
                }
                else {
                    array_hasil[i]="T";
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if (compareString(array[i], "f")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if(compareString(array[i], "G")){
                boolean isdoneG= false;
                if(i+1<array.length){
                    if(compareString(array[i+1], "H")){
//                     /  
                        if(i-2>=0){
                            if(compareString(array[i-1], "U")){
                                if(compareString(array[i-2], "C")||compareString(array[i-2], "G")||compareString(array[i-2], "L")
                                   ||compareString(array[i-2], "R")||compareString(array[i-2], "T")){
                                    array_hasil[i]="F";
                                }
                            }
                        
                        
                                    if(i-3>=0){
                                        if(compareString(array[i-3], "B")||compareString(array[i-3], "D")||compareString(array[i-3], "H")){
                                            if(i-3>=0){
                                                if(compareString(array[i-3], "H")){
                                                    array_hasil[i]="#";
                                                    }
                                                }
                                                array_hasil[i]="#";
                                            }
                                        }
                                    }
                        
                      else  { 
                        array_hasil[i]="K";
                       isdoneG=true;
                        }
                       
                    }
                    
                    else if(compareString(array[i+1], "E")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "S")||compareString(array[i+2], "P")||compareString(array[i+2], "B")||
                                    compareString(array[i+2], "L")||compareString(array[i+2], "Y")||compareString(array[i+2], "I")
                                    ||compareString(array[i+2], "R")){
                                        array_hasil[i]="K";
                            }
                            
                            if(compareString(array[i], "R")){
                                array_hasil[i]="K";
                            }
                            
                           
                            
                            
                        }
                        
                         if(i-1<0){
                                 array_hasil[i]="K";
                            }
                        
                        
                    }
                    
                    
                    else if(compareString(array[i+1], "E")){
                        array_hasil[i]="K";
                    }
                    
                    
                    else if(compareString(array[i+1], "I")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "B")||compareString(array[i+2], "L")||compareString(array[i+2], "N")||
                                    compareString(array[i+2], "E")){
                                        array_hasil[i]="K";
                            }
                        }
                    }
                    
                    
                    
                    else if(compareString(array[i+1], "N")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "E")){
                                if(i+3<array.length){
                                    if(compareString(array[i+3], "D")){
                                        array_hasil[i]="J";
                                    }
                                    
                            else{
                            array_hasil[i]="J";
                        }
                                }
                            }
                            
                            
                            else{
                            array_hasil[i]="J";
                        }
                        }
//                        
                        else{
                            array_hasil[i+1]="J";
                        }
                    }
                    
                    
                    else if(i+2<array.length){
                        
                        if(compareString(array[i+2], "N")){
                        
                            array_hasil[i]="N";
                        }
                    }
                    
                    
                    if(i+2<array.length){
                        if((compareString(array[i+2], "T"))){
                            array_hasil[i]="J";
                            isdoneG=true;
                            }
                        //selempitan
                    }
                    
                    if(compareString(array[i+1], "L")){
                        if(i-2<array.length){
                            if(compareString(array[i+2], "I")){
                                array_hasil[i]="KL";
                            }
                        }
                    }
                }
                if(i-1>=0){
                    if(compareString(array[i-1], "D")){
                        if(i+1<array.length){
                            if(compareString(array[i+1], "E")||compareString(array[i+1], "I")||compareString(array[i+1], "Y")){
                                array_hasil[i]="J";
                            }
                        }
                    }
                }
                if(compareString(array_hasil[i], "G")){
                    array_hasil[i]="K";
                }
                
            }
            else if (compareString(array[i], "H")) { //jika h
                boolean isDone=false;
                if (i-1>=0) { //cek apakah ada sebelumnya
                    if (isVokal(array[i-1])) { //cek apakah sebelumnya adalah vokal
                        if (i+1<array.length) { //cek apakah ada sesudah nya
                            if (isVokal(array[i+1])) { //apakah sesudah nya adalah vokal
                                array_hasil[i]="H"; isDone=true;
                            }
                            else {
                                array_hasil[i]=""; isDone=true;
                            }
                        } else {
                            array_hasil[i]=""; isDone=true;
                        }
                    }
                }
                if (i+1<array.length){
                    if (isVokal(array[i+1])) {
                        if (i-1>=0) {
                            boolean o = compareString(array[i-1], "C") ||
                                        compareString(array[i-1], "G") ||
                                        compareString(array[i-1], "P") ||
                                        compareString(array[i-1], "S") ||
                                        compareString(array[i-1], "T");
                            if (!o) {
                                array_hasil[i]="H"; isDone=true;
                            } else {
                                array_hasil[i]=""; isDone=true;
                            }
                        } else {
                            array_hasil[i]="H"; isDone=true;
                        }
                    }
                }
                if (!isDone) {
                    array_hasil[i]="H"; isDone=true;
                }
            }
            
            
            
            else if (compareString(array[i], "J")) {
                if (array.length==4) {
                    if ((compareString(array[i],"J"))&&(compareString(array[i+1],"O"))&&(compareString(array[i+1],"S"))&&(compareString(array[i+1],"E"))) {
                        array_hasil[i]="H";
                    }
                } else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if (compareString(array[i], "K")) {
                if (i-1>=0) {
                    if (compareString(array[i-1],"C")) {
                        array_hasil[i]="";
                    }
                } else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if(compareString(array[i], "L")){
                array_hasil[i]=array_hasil[i].toUpperCase();//do nothing
            }
            
            else if (compareString(array[i], "m")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            
            else if (compareString(array[i], "n")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            
            else if(compareString(array[i], "P")){
              if(i+1<array.length){
                if (compareString(array[i+1],"H")) {
                     array_hasil[i]="F";
                }
              }    
                else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            
            
           else if (compareString(array[i], "q")) {
               array_hasil[i]="K";
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
           else if (compareString(array[i], "r")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            //untuk s
            if (compareString(array[i], "S")) {
                boolean isDone=false;
                if ((i+3<array.length)&&(i-1>=0)) { //jika didalam -SIA- -SIO-
                    if (
                            ((compareString(array[i+1],"I"))&&(compareString(array[i+2],"A"))) ||
                            ((compareString(array[i+1],"I"))&&(compareString(array[i+2],"O")))
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+1<array.length) { //sebelum H
                    if (compareString(array[i+1], "H")) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+3<array.length) { //jika didalam SCI- SCE- SCY-
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "E"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "Y")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if ((i-2>=0)&&(i+2<array.length)) { //jika didalam -isl- -ysl-
                    if (
                            ((compareString(array[i-1], "I"))&&(compareString(array[i-1], "L"))) ||
                            ((compareString(array[i-1], "Y"))&&(compareString(array[i-1], "L"))) 
                            ) {
                        array_hasil[i]=""; isDone=true;
                    }
                }
                if (i+4<array.length) { //jika didalam sugar
                    if (
                            ((compareString(array[i+1], "U"))&&(compareString(array[i+2], "G"))
                            &&(compareString(array[i+3], "A"))&&(compareString(array[i+4], "R")))
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+1<array.length) { //jika didalam sc
                    if ((compareString(array[i+1], "C"))) {
                        if (i+2<array.length) {
                            array_hasil[i]="SK"; isDone=true; //jika sc-
                        }
                        else {
                            array_hasil[i]="X"; isDone=true; //jika sc
                        }
                    }
                }
                if (i+1<array.length) { //jika diikuti n m l w z
                    if (
                            (compareString(array[i+1], "N")) ||
                            (compareString(array[i+1], "M")) ||
                            (compareString(array[i+1], "L")) ||
                            (compareString(array[i+1], "W")) ||
                            (compareString(array[i+1], "Z")) 
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+3<array.length) { //jika diddalam sch- diikuti ER EN
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "H")))
                            ) {
                        if (i+4<array.length) {
                            if (
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "R"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "N")))
                                    ) {
                                array_hasil[i]="X"; isDone=true;
                            }
                            if (
                                    ((compareString(array[i+3], "O"))&&(compareString(array[i+4], "O"))) ||
                                    ((compareString(array[i+3], "U"))&&(compareString(array[i+4], "Y"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "D"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "M")))
                                    ) {
                                array_hasil[i]="SK"; isDone=true;
                            }
                        }
                    }
                }
                if (!isDone) { //default be S
                    array_hasil[i]="S"; isDone=true;
                }
            }
            //end of S
            else if(compareString(array[i], "T")){
                if(i+1<array.length){
                    if(compareString(array[i+1], "T")){
                        if(i+2<array.length){
                            if(compareString(array[i+2],"H")){
                                array_hasil[i]="0";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else if(compareString(array[i+2],"C")){
                                if(i+3<array.length){
                                     if((compareString(array[i+2],"C")&&(compareString(array[i+3],"H")))){
                                         array_hasil[i]="0";
                                         array_hasil[i]=array_hasil[i].toUpperCase();
                                     }
                            }
                            else{
                                array_hasil[i]="";
                            }
                        }
                    }}
                    if(compareString(array[i+1], "H")){
                        if(i+2<array.length){
                            if((compareString (array[i+1], "H"))&&(compareString(array[i+2],"O"))&&(compareString(array[i+3], "M"))){
                                array_hasil[i]="T";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else if((compareString (array[i+1], "H"))&&(compareString(array[i+2],"A"))&&(compareString(array[i+3], "M"))){
                                array_hasil[i]="T";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else{
                                array_hasil[i]="0";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                        }
                        else{
                                array_hasil[i]="0";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                        }
                    }
               }
            }
            else if (compareString(array[i], "V")) {
                array_hasil[i]="F";
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if (compareString((array[i]), "w")){
                if(i+1<array.length){
                    if(isVokal(array[i+1])){
                        array_hasil[i]="W";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing    
                    }
                    else if (compareString(array[i+1], "R")){
                        array_hasil[i]="R";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                    }
                    else if (compareString(array[i+1], "H")){
                        array_hasil[i]="A";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                    }
                    else if(compareString(array[i+1], "I")){
                        if(i+3<array.length){
                            if(compareString(array[i+2], "C")||(compareString(array[i+2], "T")&&(compareString(array[i+3], "Z")))){
                                array_hasil[i]="TX";
                                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                            }
                        }
                    }
                     if((i+3<array.length)&&(i-1>=0)){
                       if((compareString(array[i-1], "O")||(compareString(array[i],"E"))
                               &&(compareString(array[i+1], "S"))&&(compareString(array[i+2], "K")))){
                           if(compareString(array[i+3], "Y")||(compareString(array[i], "I"))){
                               array_hasil[i]="''";
                           }
                       }
                    }
                    if (i-1>=0){
                        if(compareString(array[i+1], "I")){
                            if(i+2<array.length){
                                if((compareString(array[i+2], "C"))||(compareString(array[i+2], "T"))){
                                    if(compareString(array[i+2], "Z")){
                                        array_hasil[i]="TS";
                                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                                    }
                                }
                            }
                        }
                    }
                }
                if(compareString(array_hasil[i], "W")){
                    array_hasil[i]="W";
                }
          }
            else if (compareString(array[i], "X")) {
                array_hasil[i]="KS"; // harusnya KS
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if(compareString(array[i], "Z")){
             if(i+1<array.length){
                 
                if (compareString(array[i+1],"H")) {
                     array_hasil[i]="J";
                }
                    
                else if (compareString(array[i+1], "A")){
                     array_hasil[i]="S"; //bedanya di secondary
                }
                    
                else if (compareString(array[i+1], "O")){
                     array_hasil[i]="S"; //bedanya di secondary
                }
                    
                else if (compareString(array[i+1], "I")){
                     array_hasil[i]="S"; //bedanya di secondary
                }
             }
                else {
                    array_hasil[i]="S";
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            array_hasil[i]=array_hasil[i].toUpperCase();
            String a = array[i];
            char b = a.charAt(0);
            int c = (int) b;
            if (
                    !(((c>=97) && (c<=122)) || ((c>=65)&&(c<=90)))
                    ) { //menghapus simbil
                if (c==32) {
                    array_hasil[i]=" ";
                } else {
                    array_hasil[i]="";
                }
            }
        }
        return arrayToString(array_hasil);
    }
    
    public static String konverterSecondary (String kata){
      
//        arr= kata.toCharArray();
        
        String array[]=toStringArray(kata);
        String array_hasil[]=toStringArray(kata);
        
        

        for (int i = 0; i < array.length; i++) {
            if (isVokal(array[i])||compareString(array[i], "y")) { //jika aiueoy 
                if (i==0) {
                    array_hasil[i]="A";
                } else {
                    array_hasil[i]="";
                }
            }
            else if (compareString(array[i], "b")){ //jika b
                if ((i-1>=0)&&(i==(array.length-1))) {
                    if (compareString(array[i-1], "m")) {
                        array_hasil[i]="P";
                    }
                } else {
                    array_hasil[i]="B";
                }
            }
            else if (compareString(array[i], "c")){ //jika c
                boolean isDone = false;
                if ((i-1>=0)&&(i+1<=array.length-1)) { //jika dalam -sch-
                    if ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "H"))) {
                        array_hasil[i]="K";
                        isDone=true;
                    }
                }
                if (array.length>=6) { //jika dalam ORCHES
                    if ((i-2>=0)&&(i+3<=array.length-1)) {
                        if (((compareString(array[i-2], "O"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "E"))
                                &&(compareString(array[i+3], "S"))
                                ) || ((compareString(array[i-2], "A"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "I"))
                                &&(compareString(array[i+3], "T"))
                                ) || ((compareString(array[i-2], "O"))&&(compareString(array[i-1], "R"))
                                &&(compareString(array[i+1], "H"))&&(compareString(array[i+2], "I"))
                                &&(compareString(array[i+3], "D"))
                                )
                                ){
                            array_hasil[i]="K";
                            isDone=true;
                        }
                    }
                }
                if ((i-1>=0)) { //jika dalam mc
                    if ((compareString(array[i-1], "M"))){
                        array_hasil[i]="K"; isDone=true; 
                    }
                }
                if ((i+1<=array.length-1)) { //jika dalam ck cg cq
                    if ((compareString(array[i+1], "K"))
                            ||(compareString(array[i+1], "G"))
                            ||(compareString(array[i+1], "Q"))){
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+5<=array.length-1) { //jika diikuti -harac -haris
                    if (
                            ((compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "R"))&&(compareString(array[i+4], "A"))
                            &&(compareString(array[i+5], "C"))) ||
                            ((compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "R"))&&(compareString(array[i+4], "I"))
                            &&(compareString(array[i+5], "S")))
                            ) {
                            array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika sebelum L,R,N,M,B,H,F,V,W
                    if (
                            (compareString(array[i+1], "L")) ||
                            (compareString(array[i+1], "R")) ||
                            (compareString(array[i+1], "N")) ||
                            (compareString(array[i+1], "M")) ||
                            (compareString(array[i+1], "B")) ||
                            (compareString(array[i+1], "H")) ||
                            (compareString(array[i+1], "F")) ||
                            (compareString(array[i+1], "V")) ||
                            (compareString(array[i+1], "W"))
                            ){
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if (i+3<=array.length-1) { //jika di dalam chae
                    if (
                            (compareString(array[i+1], "H"))&&(compareString(array[i+2], "A"))
                            &&(compareString(array[i+3], "E"))
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+i<=array.length-1) { //jika didalam -ci- -ce- -cy-
                    if (
                            (compareString(array[i+1], "I")) ||
                            (compareString(array[i+1], "E")) ||
                            (compareString(array[i+1], "Y"))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+5<=array.length-1) { //jika didalam -caesar-
                    if (
                            ((compareString(array[i+1], "A"))&&(compareString(array[i+2], "E"))
                            &&(compareString(array[i+3], "S"))&&(compareString(array[i+4], "A"))
                            &&(compareString(array[i+5], "R")))
                            ) {
                            array_hasil[i]="S"; isDone=true;
                    }
                }
                if ((i-1>=0)&&(i+1<=array.length-1)) { //jika dalam -sci- -scy- sce
                    if (
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "I"))) ||
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "Y"))) ||
                            ((compareString(array[i-1], "S"))&&(compareString(array[i+1], "E")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika di dalam cz
                    if ((compareString(array[i+1], "Z"))) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+3<=array.length-1) { //jika diikuti dengan -CIA -CIE -CIO
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "A"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "E"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))&&(compareString(array[i+3], "O")))
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+1<=array.length-1) { //jika didalam cc
                    if ((compareString(array[i+1], "C"))) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i-1>=0) { //jika didalam cc
                    if ((compareString(array[i-1], "C"))) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if ((i-1>=0)&&(i+3<=array.length-1)) { //jika u"c"cee u"c"ces
                    if (
                            ((compareString(array[i-1], "U"))&&(compareString(array[i+1], "C"))
                            &&(compareString(array[i+2], "E"))&&(compareString(array[i+3], "E"))) ||
                            ((compareString(array[i-1], "U"))&&(compareString(array[i+1], "C"))
                            &&(compareString(array[i+2], "E"))&&(compareString(array[i+3], "S")))
                            ) {
                        array_hasil[i]="K"; isDone=true;
                    }
                }
                if ((i-2>=0)&&(i+2<=array.length-1)) { //jika uc"c"ee uc"c"es
                    if (
                            ((compareString(array[i-2], "U"))&&(compareString(array[i-1], "C"))
                            &&(compareString(array[i+1], "E"))&&(compareString(array[i+2], "E"))) ||
                            ((compareString(array[i-2], "U"))&&(compareString(array[i-1], "C"))
                            &&(compareString(array[i+1], "E"))&&(compareString(array[i+2], "S")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if(!isDone){
                    array_hasil[i]="K";
                }
            } //end of C
            else if(compareString(array[i], "D")){ //d
                if(i+1<array.length){     
                    if (compareString(array[i+1],"G")) {
                    
                        if(i+2<array.length){
                            if(compareString(array[i+2], "E")||compareString(array[i+2], "I")
                                ||compareString(array[i+2], "Y")){
                                    array_hasil[i]="J";    
                            }
                        }
                    else{
                        array_hasil[i]="TK";//harusnya TK
                    array_hasil[i]=array_hasil[i].toUpperCase();
                    }
                 }
                   
                }
                else {
                    array_hasil[i]="T";
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if (compareString(array[i], "f")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if(compareString(array[i], "G")){
                boolean isdoneG= false;
                if(i+1<array.length){
                    if(compareString(array[i+1], "H")){
//                     /  
                        if(i-2>=0){
                            if(compareString(array[i-1], "U")){
                                if(compareString(array[i-2], "C")||compareString(array[i-2], "G")||compareString(array[i-2], "L")
                                   ||compareString(array[i-2], "R")||compareString(array[i-2], "T")){
                                    array_hasil[i]="F";
                                }
                            }
                        
                        
                                    if(i-3>=0){
                                        if(compareString(array[i-3], "B")||compareString(array[i-3], "D")||compareString(array[i-3], "H")){
                                            if(i-3>=0){
                                                if(compareString(array[i-3], "H")){
                                                    array_hasil[i]="#";
                                                    }
                                                }
                                                array_hasil[i]="#";
                                            }
                                        }
                                    }
                        
                      else  { 
                        array_hasil[i]="K";
                       isdoneG=true;
                        }
                       
                    }
                    
                    else if(compareString(array[i+1], "E")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "S")||compareString(array[i+2], "P")||compareString(array[i+2], "B")||
                                    compareString(array[i+2], "L")||compareString(array[i+2], "Y")||compareString(array[i+2], "I")
                                    ||compareString(array[i+2], "R")){
                                        array_hasil[i]="K";
                            }
                            
                            if(compareString(array[i], "R")){
                                array_hasil[i]="K";
                            }
                            
                           
                            
                            
                        }
                        
                         if(i-1<0){
                                 array_hasil[i]="K";
                            }
                        
                        
                    }
                    
                    
                    else if(compareString(array[i+1], "E")){
                        array_hasil[i]="K";
                    }
                    
                    
                    else if(compareString(array[i+1], "I")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "B")||compareString(array[i+2], "L")||compareString(array[i+2], "N")||
                                    compareString(array[i+2], "E")){
                                        array_hasil[i]="K";
                            }
                        }
                    }
                    
                    
                    
                    else if(compareString(array[i+1], "N")){
                        if(i+2<array.length){
                            if(compareString(array[i+2], "E")){
                                if(i+3<array.length){
                                    if(compareString(array[i+3], "D")){
                                        array_hasil[i]="J";
                                    }
                                    
                            else{
                            array_hasil[i]="J";
                        }
                                }
                            }
                            
                            
                            else{
                            array_hasil[i]="J";
                        }
                        }
//                        
                        else{
                            array_hasil[i+1]="J";
                        }
                    }
                    
                    
                    else if(i+2<array.length){
                        
                        if(compareString(array[i+2], "N")){
                        
                            array_hasil[i]="KN";
                        }
                    }
                    
                    
                    if(i+2<array.length){
                        if((compareString(array[i+2], "T"))){
                            array_hasil[i]="J";
                            isdoneG=true;
                            }
                        //selempitan
                    }
                    
                    if(compareString(array[i+1], "L")){
                        if(i-2<array.length){
                            if(compareString(array[i+2], "I")){
                                array_hasil[i]="L";
                            }
                        }
                    }
                }
                if(i-1>=0){
                    if(compareString(array[i-1], "D")){
                        if(i+1<array.length){
                            if(compareString(array[i+1], "E")||compareString(array[i+1], "I")||compareString(array[i+1], "Y")){
                                array_hasil[i]="J";
                            }
                        }
                    }
                }
                if(compareString(array_hasil[i], "G")){
                    array_hasil[i]="K";
                }
                
            }
            
            else if (compareString(array[i], "H")) { //jika h
                boolean isDone=false;
                if (i-1>=0) { //cek apakah ada sebelumnya
                    if (isVokal(array[i-1])) { //cek apakah sebelumnya adalah vokal
                        if (i+1<array.length) { //cek apakah ada sesudah nya
                            if (isVokal(array[i+1])) { //apakah sesudah nya adalah vokal
                                array_hasil[i]="H"; isDone=true;
                            }
                            else {
                                array_hasil[i]=""; isDone=true;
                            }
                        } else {
                            array_hasil[i]=""; isDone=true;
                        }
                    }
                }
                if (i+1<array.length){
                    if (isVokal(array[i+1])) {
                        if (i-1>=0) {
                            boolean o = compareString(array[i-1], "C") ||
                                        compareString(array[i-1], "G") ||
                                        compareString(array[i-1], "P") ||
                                        compareString(array[i-1], "S") ||
                                        compareString(array[i-1], "T");
                            if (!o) {
                                array_hasil[i]="H"; isDone=true;
                            } else {
                                array_hasil[i]=""; isDone=true;
                            }
                        } else {
                            array_hasil[i]="H"; isDone=true;
                        }
                    }
                }
                if (!isDone) {
                    array_hasil[i]="H"; isDone=true;
                }
            }
            
            
            
            else if (compareString(array[i], "J")) {
                if (array.length==4) {
                    if ((compareString(array[i],"J"))&&(compareString(array[i+1],"O"))&&(compareString(array[i+1],"S"))&&(compareString(array[i+1],"E"))) {
                        array_hasil[i]="H";
                    }
                } else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if (compareString(array[i], "K")) {
                if (i-1>=0) {
                    if (compareString(array[i-1],"C")) {
                        array_hasil[i]="";
                    }
                } else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            else if(compareString(array[i], "L")){
                array_hasil[i]=array_hasil[i].toUpperCase();//do nothing
            }
            
            else if (compareString(array[i], "m")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            
            else if (compareString(array[i], "n")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            
            else if(compareString(array[i], "P")){
              if(i+1<array.length){
                if (compareString(array[i+1],"H")) {
                     array_hasil[i]="F";
                }
              }    
                else {
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            
            
           else if (compareString(array[i], "q")) {
               array_hasil[i]="K";
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
           else if (compareString(array[i], "r")) {
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            //untuk s
            if (compareString(array[i], "S")) {
                boolean isDone=false;
                if ((i+3<array.length)&&(i-1>=0)) { //jika didalam -SIA- -SIO-
                    if (
                            ((compareString(array[i+1],"I"))&&(compareString(array[i+2],"A"))) ||
                            ((compareString(array[i+1],"I"))&&(compareString(array[i+2],"O")))
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+1<array.length) { //sebelum H
                    if (compareString(array[i+1], "H")) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+3<array.length) { //jika didalam SCI- SCE- SCY-
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "I"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "E"))) ||
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "Y")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if ((i-2>=0)&&(i+2<array.length)) { //jika didalam -isl- -ysl-
                    if (
                            ((compareString(array[i-1], "I"))&&(compareString(array[i-1], "L"))) ||
                            ((compareString(array[i-1], "Y"))&&(compareString(array[i-1], "L"))) 
                            ) {
                        array_hasil[i]=""; isDone=true;
                    }
                }
                if (i+4<array.length) { //jika didalam sugar
                    if (
                            ((compareString(array[i+1], "U"))&&(compareString(array[i+2], "G"))
                            &&(compareString(array[i+3], "A"))&&(compareString(array[i+4], "R")))
                            ) {
                        array_hasil[i]="S"; isDone=true;
                    }
                }
                if (i+1<array.length) { //jika didalam sc
                    if ((compareString(array[i+1], "C"))) {
                        if (i+2<array.length) {
                            array_hasil[i]="SK"; isDone=true; //jika sc-
                        }
                        else {
                            array_hasil[i]="S"; isDone=true; //jika sc
                        }
                    }
                }
                if (i+1<array.length) { //jika diikuti n m l w z
                    if (
                            (compareString(array[i+1], "N")) ||
                            (compareString(array[i+1], "M")) ||
                            (compareString(array[i+1], "L")) ||
                            (compareString(array[i+1], "W")) ||
                            (compareString(array[i+1], "Z")) 
                            ) {
                        array_hasil[i]="X"; isDone=true;
                    }
                }
                if (i+3<array.length) { //jika diddalam sch- diikuti ER EN
                    if (
                            ((compareString(array[i+1], "C"))&&(compareString(array[i+2], "H")))
                            ) {
                        if (i+4<array.length) {
                            if (
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "R"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "N")))
                                    ) {
                                array_hasil[i]="X"; isDone=true;
                            }
                            if (
                                    ((compareString(array[i+3], "O"))&&(compareString(array[i+4], "O"))) ||
                                    ((compareString(array[i+3], "U"))&&(compareString(array[i+4], "Y"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "D"))) ||
                                    ((compareString(array[i+3], "E"))&&(compareString(array[i+4], "M")))
                                    ) {
                                array_hasil[i]="SK"; isDone=true;
                            }
                        }
                    }
                }
                if (!isDone) { //default be S
                    array_hasil[i]="S"; isDone=true;
                }
            }
            //end of S
            else if(compareString(array[i], "T")){
                if(i+1<array.length){
                    if(compareString(array[i+1], "T")){
                        if(i+2<array.length){
                            if(compareString(array[i+2],"H")){
                                array_hasil[i]="T";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else if(compareString(array[i+2],"C")){
                                if(i+3<array.length){
                                     if((compareString(array[i+2],"C")&&(compareString(array[i+3],"H")))){
                                         array_hasil[i]="T";
                                         array_hasil[i]=array_hasil[i].toUpperCase();
                                     }
                            }
                            else{
                                array_hasil[i]="";
                            }
                        }
                    }}
                    if(compareString(array[i+1], "H")){
                        if(i+2<array.length){
                            if((compareString (array[i+1], "H"))&&(compareString(array[i+2],"O"))&&(compareString(array[i+3], "M"))){
                                array_hasil[i]="T";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else if((compareString (array[i+1], "H"))&&(compareString(array[i+2],"A"))&&(compareString(array[i+3], "M"))){
                                array_hasil[i]="T";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                            else{
                                array_hasil[i]="0";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                            }
                        }
                        else{
                                array_hasil[i]="0";
                                array_hasil[i]=array_hasil[i].toUpperCase();
                        }
                    }
               }
            }
            else if (compareString(array[i], "V")) {
                array_hasil[i]="F";
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if (compareString((array[i]), "w")){
                if(i+1<array.length){
                    if(isVokal(array[i+1])){
                        array_hasil[i]="W";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing    
                    }
                    else if (compareString(array[i+1], "R")){
                        array_hasil[i]="R";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                    }
                    else if (compareString(array[i+1], "H")){
                        array_hasil[i]="A";
                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                    }
                    else if(compareString(array[i+1], "I")){
                        if(i+3<array.length){
                            if(compareString(array[i+2], "C")||(compareString(array[i+2], "T")&&(compareString(array[i+3], "Z")))){
                                array_hasil[i]="TX";
                                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                            }
                        }
                    }
                     if((i+3<array.length)&&(i-1>=0)){
                       if((compareString(array[i-1], "O")||(compareString(array[i],"E"))
                               &&(compareString(array[i+1], "S"))&&(compareString(array[i+2], "K")))){
                           if(compareString(array[i+3], "Y")||(compareString(array[i], "I"))){
                               array_hasil[i]="''";
                           }
                       }
                    }
                    if (i-1>=0){
                        if(compareString(array[i+1], "I")){
                            if(i+2<array.length){
                                if((compareString(array[i+2], "C"))||(compareString(array[i+2], "T"))){
                                    if(compareString(array[i+2], "Z")){
                                        array_hasil[i]="TS";
                                        array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
                                    }
                                }
                            }
                        }
                    }
                }
                if(compareString(array_hasil[i], "W")){
                    array_hasil[i]="W";
                }
          }
            else if (compareString(array[i], "X")) {
                array_hasil[i]="KS"; // harusnya KS
                array_hasil[i] = array_hasil[i].toUpperCase(); //do nothing
            }
            else if(compareString(array[i], "Z")){
             if(i+1<array.length){
                 
                if (compareString(array[i+1],"H")) {
                     array_hasil[i]="J";
                }
                    
                else if (compareString(array[i+1], "A")){
                     array_hasil[i]="TS"; //bedanya di secondary
                }
                    
                else if (compareString(array[i+1], "O")){
                     array_hasil[i]="TS"; //bedanya di secondary
                }
                    
                else if (compareString(array[i+1], "I")){
                     array_hasil[i]="TS"; //bedanya di secondary
                }
             }
                else {
                    array_hasil[i]="S";
                    array_hasil[i]=array_hasil[i].toUpperCase(); //do nothing
                }
            }
            array_hasil[i]=array_hasil[i].toUpperCase();
            String a = array[i];
            char b = a.charAt(0);
            int c = (int) b;
            if (
                    !(((c>=97) && (c<=122)) || ((c>=65)&&(c<=90)))
                    ) { //menghapus simbil
                if (c==32) {
                    array_hasil[i]=" ";
                } else {
                    array_hasil[i]="";
                }
            }
        }
        return arrayToString(array_hasil);
    }

    public static  boolean compareString (String chr2, String chr){
       chr = chr.toUpperCase();
       chr2 = chr2.toUpperCase();
        if (chr == null ? chr2 == null : chr.equals(chr2)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static  boolean isVokal (String compare){
        if (
                    (compare.equalsIgnoreCase("a")) ||
                    (compare.equalsIgnoreCase("i")) ||
                    (compare.equalsIgnoreCase("u")) ||
                    (compare.equalsIgnoreCase("e")) ||
                    (compare.equalsIgnoreCase("o")) 
                ) 
            {
                return true;
            }
        else {
            return false;
        }
    }

     public static  String[] toStringArray(String a) {
        
        String result[] = new String[a.length()];
        for (int i = 0; i <a.length(); i++) {
            
            result[i]=a.substring(i,i+1);
        }
        return result;
    }

        public String Stringtoword (String [] str){
        String temp = "";
        for (int i = 0; i < str.length; i++) {
            temp = temp + str[i];
        }
        return temp;
    }
     
     
    public String charToString (char [] chr){
        String temp = "";
        for (int i = 0; i < chr.length; i++) {
            temp = temp + chr[i];
        }
        return temp;
    }
    
    public static  String arrayToString (String [] chr){
        String temp = "";
        for (int i = 0; i < chr.length; i++) {
            temp = temp + chr[i];
        }
        return temp;
    }
}
