package JAVA;

public class Aritmetica {

    public int b;
    public int a;

    //El constructor es un metodo especial
    public Aritmetica(){
       System.out.println("Se esta ejecutando este constructor numero uno");
    }
    // Estamos viendo lo que se llama sobrecarga de constructores
    public Aritmetica(int a, int b ){
       this.a = a;
       this.b = b;
       System.out.println("Se esta ejecutando este constructor numero dos ");
    }

    //Metodos
    
    public void sumarNumeros(){
        int resultado = a + b;
        System.out.println("resultado = " + resultado);
    }
    public int sumarConRetorno (){
        //int resultado = a + b;
        int resultado = a + b;
        return a + b;
    }
    public int sumarConArgumentos(int arg1,int arg2){ // en vez de int no se puede poner var NO 
        this.a = arg1 ; // El argumento a se asigna al atributo this.a
        this.b = arg2 ;
        //return a + b;
        return this.sumarConRetorno();
    }
}
