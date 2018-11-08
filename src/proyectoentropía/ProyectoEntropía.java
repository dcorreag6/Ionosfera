package proyectoentropía;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
/**
 * @author al171800
 */
public class ProyectoEntropía
{
    public static void main(String[] args)
    {
        String n = null, name=null;
        int t,i = 0,cont=0,cont2=0,h=0,j2,band,i1,i2,y,f,c1 = 0,b;//cont=columnas,cont2=renglones,
        double H,e=0.5;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Hola, ingresa el nombre del archivo exactamente como lo encuentres en el explorador de archivos");
        name=entrada.nextLine();
        name=name+".csv";
        String j[]; //encabezado
        String k[][] = null; //todos los datos 
        String d[][]=null;//simbolos diferentes
        AplicarFormula a=new AplicarFormula();
        
        try
        {   
            FileReader input=new FileReader(name);
            BufferedReader binput=new BufferedReader(input);
            n=binput.readLine();
            for(i=0;i<n.length();i++)
            {
                if(n.charAt(i)==',')
                {
                    cont++;
                }
            }
            cont++;
            j=new String[cont];
            for(i=0;i<cont;i++)
            {
                j[i]="";
            }
            i=0;
            
            for(h=0;h<n.length();h++)
            {
                if(n.charAt(h)!=',')
                {
                    j[i]=j[i]+n.charAt(h);
                }
                else
                {
                    i++;
                }
            }
            
            while(n!=null)
            {
                n=binput.readLine();
                if (n==null)
                {
                    cont2=cont2-1;
                }
                else
                {
                     cont2++;
                   // System.out.println(""+n);
                }
                
            }
            k= new String[cont2][cont];
            binput.close();
        }
        catch(IOException ex)
        {
            System.out.println("\nNo se pudo cargar el archivo\n");
        }
        try //AQUI VALE VERDOLAGA
        {
            FileReader input=new FileReader(name);
            BufferedReader binput=new BufferedReader(input);
            binput.readLine();
            for(t=0;t<cont2;t++)
            {
                for(h=0;h<cont;h++)
                {
                    k[t][h]="";
                }
            }
            for(t=0;t<cont2;t++)
            {
                n=binput.readLine();
                i=0;
                for(h=0;h<n.length()-1;h++)
                {
                    if(n.charAt(h)!=',')
                    {
                        k[t][i]= k[t][i]+n.charAt(h);
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        }
        
        
        catch(IOException ex)
        {
            System.out.println("\nNo se pudo cargar el archivo\n");
        }
        
        
          
        /*if(cont>1)
                    {
                        d[i][0]=k[i1][0];
                    }
                    */
        //Recorrer el arreglo de datos
        i=1;
        H=a.Entropia(cont, d, k, cont2, i);
        while(H>e)
        {
            H=H-a.Entropia(cont, d, k, cont2, i);
            i++;
        }
        
    }   
}

/* 
El barbas se la come 
*/