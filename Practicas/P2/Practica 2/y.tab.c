#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 1 "forma.y"

import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
#line 14 "y.tab.c"
#define NUMBER 257
#define LINE 258
#define RIGHT 259
#define CIRCULO 260
#define RECTANGULO 261
#define COLOR 262
#define PRINT 263
#define VAR 264
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    0,    1,    1,    1,    1,    1,
};
short yylen[] = {                                         2,
    0,    2,    3,    1,    8,    6,    2,    8,
};
short yydefred[] = {                                      1,
    0,    4,    0,    0,    0,    0,    2,    0,    0,    0,
    0,    7,    3,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    6,    0,    0,    0,    5,    8,
};
short yydgoto[] = {                                       1,
    8,
};
short yysindex[] = {                                      0,
  -59,    0, -256, -255, -254, -253,    0,  -54,  -38,  -37,
  -36,    0,    0, -248, -247, -246,  -32,  -31,  -30, -242,
 -241, -240,  -26,    0,  -25, -237, -236,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
    0,
};
#define YYTABLESIZE 203
short yytable[] = {                                       7,
    9,   10,   11,   12,   13,   14,   15,   16,   17,   18,
   19,   20,   21,   22,   23,   24,   25,   26,   27,   28,
   29,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    2,    3,    0,
    4,    5,    6,
};
short yycheck[] = {                                      59,
  257,  257,  257,  257,   59,   44,   44,   44,  257,  257,
  257,   44,   44,   44,  257,  257,  257,   44,   44,  257,
  257,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,   -1,
  260,  261,  262,
};
#define YYFINAL 1
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 264
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,"','",0,0,0,0,0,0,0,0,0,0,0,0,0,0,"';'",0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"NUMBER","LINE","RIGHT",
"CIRCULO","RECTANGULO","COLOR","PRINT","VAR",
};
char *yyrule[] = {
"$accept : list",
"list :",
"list : list ';'",
"list : list inst ';'",
"inst : NUMBER",
"inst : LINE NUMBER ',' NUMBER ',' NUMBER ',' NUMBER",
"inst : CIRCULO NUMBER ',' NUMBER ',' NUMBER",
"inst : COLOR NUMBER",
"inst : RECTANGULO NUMBER ',' NUMBER ',' NUMBER ',' NUMBER",
};
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 55 "forma.y"


/*Algo a Construir, tiene Simbolo e instrucción*/
class Algo {
	Simbolo simb;
	int inst;
	public Algo(int i)
  { 
    inst=i; 
  }
	public Algo(Simbolo s, int i)
  {
		simb=s;
    inst=i;
	}
}

/*Los manda llamar del Código previo de Java*/
Tabla tabla;
Maquina maq;

/*Divide la cadena en tokens y revisa si existe nueva línea a leer*/
StringTokenizer st;
boolean newline;

/*Analizador Léxico*/
int yylex()
{
  /*Cadena, Tokens, tipo y Símbolo*/
  String s;
  int tok;
  Double d;
  Simbolo simbo;

  /*Verificación de cadena*/
   if (!st.hasMoreTokens())
      if (!newline) 
      {
        newline=true; 
	      return ';';  
      }
   else
      return 0;

   s = st.nextToken();

   try 
   {
     /**/
      d = Double.valueOf(s);
      yylval = new ParserVal(
               new Algo(tabla.install("", NUMBER, d.doubleValue()),0) );
      tok = NUMBER;
   } catch (Exception e){
      if(Character.isLetter(s.charAt(0)))
      {
        if((simbo=tabla.lookup(s))==null)
          yylval = new ParserVal(new Algo(simbo, 0));
	        tok= simbo.tipo;	
      } else 
      {
    	  tok = s.charAt(0);
      }
   }
   return tok;
}

void yyerror(String s)
{
   System.out.println("parser error: "+s);
}

static Parser par = new Parser(0);
static JFrame f;
static JTextField t=new JTextField(20);
static JButton bcalc;
static JLabel lmuestra=new JLabel("                                 ");
static Canvas canv;
static Graphics g;

Parser(int foo)
{
   f=new JFrame("Calcula");

   bcalc=new JButton("Ejecuta");

   bcalc.addActionListener(new ManejaBoton());
   canv=new Canvas();
   canv.setSize(300,300);
   f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
}

public static void main(String args[])
{
  f.add("North", t);
  f.add("Center", canv);
  f.add("South", bcalc);
  f.setSize( 300, 400);
  f.setVisible(true);
  g=canv.getGraphics();
}

class ManejaBoton implements ActionListener 
{
   public void actionPerformed(ActionEvent e)
   {
      JButton jb=(JButton)e.getSource();

      if(jb == bcalc)
      {
        maq=new Maquina(g);
	      tabla=new Tabla();
	      tabla.install("line", LINE, 0.0);
        tabla.install("circulo", CIRCULO, 0.0);
        tabla.install("color", COLOR, 0.0);
        tabla.install("rectangulo", RECTANGULO, 0.0);
	      tabla.install("print", PRINT, 0.0);
	      st = new StringTokenizer(t.getText());
    	  newline=false;
	      for(maq.initcode(); par.yyparse ()!=0; maq.initcode())
	        maq.execute(maq.progbase);
      }
   }
}
#line 279 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 3:
#line 16 "forma.y"
{ 
             maq.code("print"); maq.code("STOP"); return 1 ;
     }
break;
case 4:
#line 21 "forma.y"
{ ((Algo)yyval.obj).inst=maq.code("constpush");/*Push en Pila*/
                maq.code(((Algo)yyvsp[0].obj).simb); }
break;
case 5:
#line 24 "forma.y"
{
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-6].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-4].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-2].obj).simb);
                maq.code("constpush");
                maq.code(((Algo)yyvsp[0].obj).simb); maq.code("line");}
break;
case 6:
#line 34 "forma.y"
{
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-4].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-2].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[0].obj).simb); maq.code("circulo");}
break;
case 7:
#line 42 "forma.y"
{ maq.code("constpush");
                maq.code(((Algo)yyvsp[0].obj).simb); maq.code("color");}
break;
case 8:
#line 45 "forma.y"
{
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-6].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-4].obj).simb); 
                maq.code("constpush");
                maq.code(((Algo)yyvsp[-2].obj).simb);
                maq.code("constpush");
                maq.code(((Algo)yyvsp[0].obj).simb); maq.code("rectangulo");}
break;
#line 469 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
