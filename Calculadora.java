package Calculadora;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener {
	JTextField display= new JTextField("0.0");
	JPanel panel = new JPanel( new GridLayout(7, 5, 5, 5));
	Font f = new Font("Courier", Font.PLAIN | Font.BOLD, 40);
	Font fb = new Font("Courier", Font.PLAIN | Font.BOLD, 15);
	Font fshift= new Font("Courier", Font.PLAIN | Font.BOLD, 10);
	String salida = "";
	double memoria = 0D;
	double oper1=0D, oper2 = 0D;
	char operador = '\0';
	boolean punto=false;
	boolean shift=false;
	final String botMsg[] = {
			"MC", "MR", "MS", "M+", "M-",
			"Del", "CE", "C", "+|-", "√",
			"7", "8", "9", "/", "%",
			"4", "5", "6", "*", "1/x",
			"1", "2", "3", "+", "x²",
			"0", ".", "y^x", "-", "=",
			"String","sin","cos","In","log"
	};
	JButton boton[] = new JButton[botMsg.length];
	
    public Calcular( ) {
    	super("Calculadora 2015");
    	for( int i = 0; i < boton.length; i++) {
    		boton[i] = new JButton(botMsg[i]);
    		boton[i].setFont( fb );
    		if(i<10){
    			boton[i].setBackground( new Color(20,20,20));
    			boton[i].setForeground(new Color(200,200,200));
    		}else if(i<30){
    			boton[i].setBackground( new Color(50,100,200));
    			boton[i].setForeground(new Color(20,20,20));
    		}else{
    			boton[i].setBackground( new Color(20,20,20));
    			boton[i].setForeground(new Color(200,200,200));
    		}
    		boton[i].addActionListener( this );
    		panel.add(boton[i]);
		}
		boton[30].setBackground(new Color(20,20,20));
		boton[30].setForeground(new Color(50,100,200));
		boton[30].setFont(fshift);
    	boton[6].setForeground(new Color(50,100,200));
    	boton[7].setForeground(new Color(50,100,200));
    	display.setFont( f );
    	display.setEditable( false );
    	display.setHorizontalAlignment(SwingConstants.RIGHT );
    	add( display, BorderLayout.NORTH);
    	add( panel, BorderLayout.CENTER);
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    	setLocation( 200, 30);
    	setSize( 440, 475);
    	setVisible( true );
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton[30]){
			if(shift) {
				shift=false;
				boton[30].setBackground(new Color(20,20,20));
				boton[30].setForeground(new Color(50,100,200));
				boton[31].setText("sin");
				boton[32].setText("cos");
				boton[33].setText("ln");
				boton[34].setText("log");
			}else{
				shift=true;
				boton[30].setBackground(new Color(50,100,200));
				boton[30].setForeground(new Color(20,20,20));
				boton[31].setText("sin-1");
				boton[32].setText("cos-1");
				boton[33].setText("e^x");
				boton[34].setText("10^x");
			}
		}
		if(e.getSource() == boton[31] && salida != "" ){
			oper1 = Double.parseDouble( salida );
			double resultado=0D;
			if(!shift){
				resultado= Math.sin(oper1);
			}else{
				resultado= Math.asin(oper1);
			}
			if( resultado - (long) resultado == 0) {
				  long tmp = (long) resultado;
				  salida = Long.toString( tmp );
				  punto = false;
			}else {
				  salida = Double.toString( resultado );
				  punto = true;
			}
		}
		if(e.getSource() == boton[32] && salida != "" ){
			oper1 = Double.parseDouble( salida );
			double resultado=0D;
			if(!shift){
				resultado= Math.cos(oper1);
			}else{
				resultado= Math.acos(oper1);
			}
			if( resultado - (long) resultado == 0) {
				  long tmp = (long) resultado;
				  salida = Long.toString( tmp );
				  punto = false;
			}else {
				  salida = Double.toString( resultado );
				  punto = true;
			}	
		}
		if(e.getSource() == boton[33] && salida != "" ){
			oper1 = Double.parseDouble( salida );
			double resultado=0D;
			if(!shift){
				resultado= Math.log(oper1);
			}else{
				resultado= Math.exp(-oper1);
			}
			if( resultado - (long) resultado == 0) {
				  long tmp = (long) resultado;
				  salida = Long.toString( tmp );
				  punto = false;
			}else {
				  salida = Double.toString( resultado );
				  punto = true;
			}	
		}
		if(e.getSource() == boton[34] && salida != "" ){
			oper1 = Double.parseDouble( salida );
			double resultado=0D;
			if(!shift){
				resultado= Math.log10(oper1);
			}else{
				resultado= Math.expm1(oper1);
			}
			if( resultado - (long) resultado == 0) {
				  long tmp = (long) resultado;
				  salida = Long.toString( tmp );
				  punto = false;
			}else {
				  salida = Double.toString( resultado );
				  punto = true;
			}	
		}
		if( e.getSource() == boton[0] && salida != "" ){
			memoria = 0D;
		}
		else if( e.getSource() == boton[1] ) {
			  if( memoria - (long) memoria == 0) {
				  long tmp = (long) memoria;
				  salida = Long.toString( tmp );
				  punto = false;
			  }
			  else {
				  salida = Double.toString( memoria );
				  punto = true;
			  }
		}
		else if( e.getSource() == boton[2] && salida != "") {
			memoria = Double.parseDouble( salida );
		}
		else if( e.getSource() == boton[3] && salida != "") {
			memoria += Double.parseDouble( salida );
		}
		else if( e.getSource() == boton[4] && salida != "") {
			memoria -= Double.parseDouble( salida );
		}
		else if( e.getSource() == boton[7] && salida != "") {
		     salida = "";
		     oper1 = 0D;
		     oper2 = 0D;
		     operador = '\0';
		     punto = false;
		}
		else if( e.getSource() == boton[29] && salida != "" && operador != '\0' ) {
			oper2 = Double.parseDouble( salida );
			salida = "";
			punto = false;
			double resultado=0D;
			switch( operador ) {
			    case '+': resultado = oper1 + oper2; break;
			    case '-': resultado = oper1 - oper2; break;
			    case '*': resultado = oper1 * oper2; break;
			    case '/': resultado = oper1 / oper2; break;
			    case '%': resultado = oper2 * (oper1 *.01); break;
			    case 'y': resultado = Math.pow( oper1,  oper2); break;
			}
			  if( resultado - (long) resultado == 0) {
				  long tmp = (long) resultado;
				  salida = Long.toString( tmp );
				  punto = false;
			  }
			  else {
				  salida = Double.toString( resultado );
				  punto = true;
			  }

		}
		if( e.getSource() == boton[27] && salida != "" ) {
		     oper1 = Double.parseDouble( salida );
		     salida = "";
		     punto = false;
		     operador= boton[27].getText().charAt(0);			
		}
		if( e.getSource() == boton[14] && salida != "" ) {
		     oper1 = Double.parseDouble( salida );
		     salida = "";
		     punto = false;
		     operador= boton[14].getText().charAt(0);			
		}
		for( int i = 13; i <= 28; i+=5) {
			if( e.getSource() == boton[i] && salida != "") {
			     oper1 = Double.parseDouble( salida );
			     salida = "";
			     punto = false;
			     operador= boton[i].getText().charAt(0);
			     break;
			}
		}
		
		
		for( int i=0; i < boton.length; i++) {
			if(   e.getSource() == boton[i] && 
				  ( i == 10 || i == 11 || i == 12 || i == 15 || i == 16 || 
        		    i == 17 || i == 20 || i == 21 || i == 22 || i == 25 )
        	  ) {
        		 salida = salida + boton[i].getText();
        	}
		}
		if( e.getSource() == boton[26] && !punto ) {
			if( salida == "" ) salida = "0.";
			else salida = salida + ".";		
   		    punto=true;
		}
		else if( e.getSource() == boton[5] && salida.length() > 0) {
			if( salida.substring( salida.length() - 1).equals(".") ) 
				punto = false;
			if ( salida.length() == 1) salida = "";
			else if( salida.length() > 1)
				salida = salida.substring( 0, salida.length() - 1 );
		}
		else if( e.getSource() == boton[8] && salida.length() > 0) {
			if( Double.parseDouble( salida ) - (int) Double.parseDouble( salida ) == 0){
				salida = "" + (int) ( -Double.parseDouble( salida )) ;
				punto = false;
			}
			else 
			salida = Double.toString( -Double.parseDouble(salida) ); 
		}
		else if( e.getSource() == boton[9] && salida.length() > 0) {
			salida = Double.toString( Math.sqrt(Double.parseDouble(salida )) );
			if( Double.parseDouble( salida ) - (int) Double.parseDouble( salida ) == 0){
				salida = "" + (int) ( Double.parseDouble( salida )) ;
				punto = false;
			}
		}
		else if( e.getSource() == boton[19] && salida.length() > 0) {
			salida = Double.toString( 1D / Double.parseDouble(salida ) );
			if( Double.parseDouble( salida ) - (int) Double.parseDouble( salida ) == 0){
				salida = "" + (int) ( Double.parseDouble( salida )) ;
				punto = false;
			}
		}
		else if( e.getSource() == boton[24] && salida.length() > 0) {
			salida = Double.toString( Double.parseDouble(salida ) * 
					                          Double.parseDouble(salida) );
			if( Double.parseDouble( salida ) - (int) Double.parseDouble( salida ) == 0){
				salida = "" + (int) ( Double.parseDouble( salida )) ;
				punto = false;
			}
		}
		if( salida != "" && !punto ) display.setText( salida +".0");
		else if ( salida != "" ) display.setText(salida);
        else display.setText("0.0");
	}

	public static void main(String[] args) {
            new Calculadora() ;
	}

}
