package gui;

import bash.CommandExecuter;
import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ExecuteButton extends JButton {
    private List<Field> fields;
    private Ibatcheable origin;

	ExecuteButton(Ibatcheable origin, List<Field> fields){
		super("Run");
		this.fields = fields;
		this.origin = origin;
		addActionListener(e -> {
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
                        System.out.println("Shit happends bro!");
                        //TODO: Manejar error
                    }
                }catch (IllegalAccessException ex){
                    //No deberia entrar nunca
                    ex.printStackTrace();
                }
            });
            CommandExecuter.execute(output.toString());
        });
	}

	private List<Field> getFields(){
	    return this.fields;
    }

    private Ibatcheable getOrigin(){
	    return this.origin;
    }
}
