package proyectoentropía;

public class AplicarFormula
{
    private double max=0;
    private double sumatot;
    private double suma1;
    private double suma2;
    private int band;
    
    public double Entropia(int cont, String d[][], String k[][],int cont2,int simbolos)
    {
        for(int i3=0;i3<cont;i3++)
        {
            sumatot=0;
            for(int i1=0;i1<simbolos;i1++)
            {
                for(int j2=0;j2<cont2;j2++)
                {
                    if(d[i1][i3]==k[j2][i3]) 
                    {
                        band=1;
                    }
                    else
                    {
                        band=0;
                    }
                    suma1=suma1+(band/cont2);
                }
                for(int i2=0;i2<simbolos;i2++)
                {
                    if(d[i1][i3]==k[i2][i3]) 
                    {
                        band=1;
                    }
                    else
                    {
                        band=0;
                    }
                    suma2=suma2+(band/cont2);
                }
                sumatot=sumatot+(suma1*(Math.log10(suma2) / Math.log10(2)));//tal vez sea base 2 
            }
            if(sumatot>max)
            {
                max=sumatot;
            }
        }
        return max;
    }
}
