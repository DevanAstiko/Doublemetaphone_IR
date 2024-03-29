/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fix_stki;

/**
 *
 * @author Fachrian Anugerah
 */
public class CosineSimilarity {
    public double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;
        /*for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            System.out.print("    "+docVector1[i]);
        }System.out.println("");
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            System.out.print("    "+docVector2[i]);
        }*/
//System.out.println("");
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
            //System.out.println("dotProduct "+i+" = "+docVector1[i] +" * "+ docVector2[i]);
            //System.out.println("magnitude1 mathpow = "+magnitude1);
            //System.out.println("magnitude2 mathpow = "+magnitude2);
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)
        
        //System.out.println("magnitude1 = "+magnitude1);
        //System.out.println("magnitude2 = "+magnitude2);
        
        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
}
