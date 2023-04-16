import kotlin.collections.*

abstract class FunctieLogica()
{
    var fct: String = "";
    abstract fun execute():Boolean;
}

class poartaLogica():FunctieLogica()        //implementam bridge, decuplam poarta logica de functia logica
{
    var intrari = mutableListOf<Boolean>()
    var rezultat = false
    override fun execute():Boolean
    {
        when(fct)
        {
            "AND" -> {rezultat = true; for(valoare in intrari)rezultat = rezultat and valoare;}
            else -> {println("functie logica nerecunoscuta")}
        }
        return rezultat
    }
    fun print()
    {
        print("functia logica: "+fct+" intrari: ");
        for(valr in intrari)
            print(valr.toString()+" ");
        print("rezultat: "+rezultat.toString()+"\n");
    }
}

class BuilderPL()                           //implementam sablonul builer cu ajutorul caruia evitam constructorii incarcati
{                                           //cream clasa Builder care are un membru de tipul clasei initiale si il initializeaza proprietate cu proprietate
    var PL: poartaLogica = poartaLogica();
    fun addFctLogica(fct: String)
    {
        PL.fct = fct;
    }
    fun addIntrare(valoare: Boolean)
    {
        PL.intrari.add(valoare)
    }
    fun returnBuild():poartaLogica
    {
        return PL
    }
}



fun main()
{
    var builderPL2 = BuilderPL()
    builderPL2.addFctLogica("AND")
    builderPL2.addIntrare(true)
    builderPL2.addIntrare(false)
    var AND2 = builderPL2.returnBuild()
    AND2.execute();
    AND2.print()

    var builderPL4 = BuilderPL()
    builderPL4.addFctLogica("AND")
    builderPL4.addIntrare(true);
    builderPL4.addIntrare(true);
    builderPL4.addIntrare(true);
    builderPL4.addIntrare(true);
    var AND4 = builderPL4.returnBuild();
    AND4.execute();
    AND4.print();

}