
import java.awt.*;
import java.util.*;
import java.lang.reflect.*;

class  Maquina 
{
	Stack pila;
	Vector prog;

	static int pc=0;
	int progbase=0;
	boolean returning=false;

	int numArchi=0;
	Method metodo;
	Method metodos[];

	Class c;
	Graphics g;
	double angulo;
	int x=0, y=0;
	Class parames[];

	Maquina(Graphics g)
	{ 
		this.g=g; 
	}

	public Vector getProg()
	{ 
		return prog; 
	}

	void initcode()
	{
        	pila=new Stack();
		prog=new Vector();
	}

	Object pop()
	{ 
		return pila.pop(); 
	}

	int code(Object f)
	{
		System.out.println("Gen ("+f+") size="+prog.size());
   		prog.addElement(f);
		return prog.size()-1;
	}

	void execute(int p)
	{
		String inst;
		System.out.println("progsize="+prog.size());
		
		for(pc=0;pc < prog.size(); pc=pc+1)
		{
			System.out.println("pc="+pc+" inst "+prog.elementAt(pc));
		}
		for(pc=p; !(inst=(String)prog.elementAt(pc)).equals("STOP") && !returning;)
		{
		//for(pc=p;pc < prog.size();){
			try 
			{
				//System.out.println("111 pc= "+pc);
				inst=(String)prog.elementAt(pc);
				pc=pc+1;
				System.out.println("222 pc= "+pc+" instr "+inst);
				c=this.getClass();
				//System.out.println("clase "+c.getName());
				//metodo=c.getDeclaredMethod(inst, null);
				//metodo.invoke(this, null);
				metodo=c.getDeclaredMethod(inst);
				metodo.invoke(this);
			}catch(NoSuchMethodException e)
			{
				System.out.println("No metodo "+e);
			}catch(InvocationTargetException e)
			{
				System.out.println(e);
			}catch(IllegalAccessException e)
			{
				System.out.println(e);
                        }
		}
	}
	void constpush()
	{
		Simbolo s;
		Double d;

		s=(Simbolo)prog.elementAt(pc); /*Elemento de la Lista esecificadoo */
		pc=pc+1;
		pila.push(new Double(s.val));
	}
	void color()
	{
        Color colors[]={Color.red,Color.green,Color.blue,Color.black,Color.pink};
		double d1;

		d1=((Double)pila.pop()).doubleValue();

		if(g!=null)
		{
			g.setColor(colors[(int)d1]);
		}
        }
	void line()
	{
		
		double x1, y1, x2, y2;
		y2=((Double)pila.pop()).doubleValue();
		x2=((Double)pila.pop()).doubleValue();
		y1=((Double)pila.pop()).doubleValue();
		x1=((Double)pila.pop()).doubleValue();
		
		if(g!=null)
		{
			(new Linea((int)x1, (int)y1, (int)x2, (int)y2)
			).dibuja(g);
		}
		System.out.println("Linea: x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2);
	}
	void circulo()
	{
		double d1,d2,d3;
		d1=((Double)pila.pop()).doubleValue();
		d2=((Double)pila.pop()).doubleValue();
		d3=((Double)pila.pop()).doubleValue();

		System.out.println("Hola soy un Circulo"+d1);
		if(g!=null)
		{
			 (new Circulo((int)d3, (int)d2, (int)d1)).dibuja(g);
                }
        }
	void rectangulo()
	{
		double d1,d2,d3, d4;
		
		d1=((Double)pila.pop()).doubleValue();
		d2=((Double)pila.pop()).doubleValue();
		d3=((Double)pila.pop()).doubleValue();
		d4=((Double)pila.pop()).doubleValue();

		System.out.println("Hola Soy un Rectangulo"+d1);
		if(g!=null)
		{
			(new Rectangulo((int)d4,(int)d3, (int)d2, (int)d1)).dibuja(g);
                }
        }
	void print()
	{
		Double d;
		d=(Double)pila.pop();
		System.out.println(""+d.doubleValue());
	}
	void prexpr()
	{
		Double d;
		d=(Double)pila.pop();
		System.out.print("["+d.doubleValue()+"]");
	}
}
