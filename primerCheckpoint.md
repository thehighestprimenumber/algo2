~~~java
@Batcheable(nombre="ffmpeg")
public class Ffmpeg {

@Parametro(flag="-i", label="inputVideo", controller="gui.unFileChooser" optional=true)
private String inputVideo;

/*@Parametro(flag="-i", label="inputVideo", controller="gui.unFileChooser" optional=true)
private List<String> parametros;*/
}
~~~

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parametro{
    String flag() default "";
    String label();
    Controller controller();
    bool optional() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Batcheable{
    String name();
}
```

```java
public void main () {
    new ClaseVisual(new Ffmeg()).display();
}

public class ClaseVisual{
    List <Field> fields;
    
    public class ClaseVisual(Object batcheable) {
        for (Field field : batcheable.getFields()) {
            if (field.isAnnotationPresent(Parametro.class))
                fields.add(field);
         }
    }
    public void display(){
        JPanel panel = new Panel()
        for (Field f : fields){
            panel.add(f.getAnnotation(Parametro.class).label())
			panel.add(f.getAnnotation(Parametro.class).controller());
            //TODO bindear controladores a fields.
        }
        panel.addButton(new ButtonEjecutar(batcheable)); 
        panel.addButton(new Button("Cancelar")); //TODO ponerle el comportamiento
    }
    
}

public class ButtonEjecutar extends JButton {
    @Override
    public void onClick(Object batcheable) {
        new TerminalExecutor(batcheable).execute();
    }
}

public class TerminalExecutor(Object batcheable) {
    //TODO constructor;
    Object batcheable;
    public void execute(){
    for (Field f : batcheable.fields) {
            if (!f.optional && f.isEmpty()) 
                throw new ParametroVacioException();
        }
        String output = batheable.getAnnotation(Batcheable.class).command();
    	for (Field f : batcheable.fields) {
            if (f.getValue() != null);
        	output+= " " + f.getAnnotation(Parametro.class).flag()+ " " + f.getValue();
        }
        //TODO mandar a la consola
     }
}
```

