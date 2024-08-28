import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java Main <cadena> <tipo>");
            System.out.println("<tipo>: 1 - 'Hola mundo' exacto, 2 - 'Hola mundo' insensible a mayúsculas, 3 - Lenguajes de programación, 4 - Correo Unison, 5 - Nombre de archivo ISI");
            return;
        }

        String cadena = args[0];
        int tipo = Integer.parseInt(args[1]);
        String regex = "";

        switch (tipo) {
            case 1:
                regex = "\\bHola mundo\\b";
                break;
            case 2:
                regex = "(?i)\\bHola mundo\\b";
                break;
            case 3:
                regex = "\\b(Java|Python|Go|Pascal|Perl)\\b";
                break;
            case 4:
                regex = "^[a-zA-Z0-9._%+-]+@(unison\\.mx|uson\\.mx)$";
                break;
            case 5:
                regex = "^ISI\\d{4}-[12]\\.(txt|csv)$";
                break;
            default:
                System.out.println("Tipo no válido.");
                return;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadena);

        if (matcher.find()) {
            System.out.println("La cadena es válida.");
        } else {
            System.out.println("La cadena no es válida.");
        }
    }
}
