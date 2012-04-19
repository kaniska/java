package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author jbu
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@interface Note {
   String author() default "TCSDEVELOPER";
   String note();
   int version();
}

@Note(note="Finish this class!", version=1)
public class AnnotDemo {
    public static void main (String args[]) {
      Note note = AnnotDemo.class.getAnnotation(Note.class);
      if (note != null) {
         System.out.println("Author=" + note.author());
         System.out.println("Note=" + note.note());
         System.out.println("Version=" + note.version());
      } else {
         System.out.println("Note not found.");
      }
    }
}
