package gui;

import bash.CommandExecuter;
import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.*;

@SuppressWarnings("serial")
public class ExecuteButton extends JButton {
    private List<Field> fields;
    private Ibatcheable origin;

	ExecuteButton(Ibatcheable origin, List<Field> fields){
		super("Run");
		this.fields = fields;
		this.origin = origin;
		addActionListener(e -> {
			List<Field> emptyNonOptional = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            output.append(getOrigin().getClass().getAnnotation(Batcheable.class).command());

            getFields().forEach(field -> {

                field.setAccessible(true);
                Object o;

                try{
                    o = field.get(getOrigin());
                    if(	o != null && !o.toString().isEmpty()){

                        output.append(" ");
                        output.append(field.getAnnotation(Parameter.class).flag());
                        output.append(" ");
                        output.append(o.toString());

                    }else if(!field.getAnnotation(Parameter.class).optional()){
                        System.out.println("LOG: el parametro " + field.getName() + " es obligatorio y no fue rellenado");
	                    emptyNonOptional.add(field);
                    }
                }catch (IllegalAccessException ex){
                    //No deberia entrar nunca
                    ex.printStackTrace();
                }
            });

            if(emptyNonOptional.isEmpty()) {
	            if(!CommandExecuter.execute(output.toString()))
		            this.openResultWindow("Error", "Ocurrio un error durante la ejecucion del comando");
            }else {
				this.openResultWindow("Error", "Hay campos obligatorios que no han sido rellenados");
            }

        });
	}

	private void openResultWindow(String title, String text){
		//TODO: hacerlo mas bonito
		JFrame frame = new JFrame(title);

		JTextField texto = new JTextField();
		texto.setText(text);
		texto.setEditable(false);
		texto.setAlignmentX(JTextField.CENTER_ALIGNMENT);

		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(texto);
		frame.setSize(350, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private List<Field> getFields(){
	    return this.fields;
    }

    private Ibatcheable getOrigin(){
	    return this.origin;
    }
}
