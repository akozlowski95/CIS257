/*
 * @topic T10170 Desktop Calculator v3
 * @brief main driver program
*/
package wk03_calc_v3;

public class MainApp {

    public static void main(String[] args) {
        for(;;) {
            StringBuilder input = new StringBuilder(
                    Validator.getString( Validator.sc, "> " )
            );
            if ( "quit".equals( input.toString() ) ) {
                System.out.println( "Bye!" );
                System.exit( 0 );
            }
            Lexer lexer = new Lexer( input, AstNode.symbolTable );
            if ( lexer.startRule() ) {
                //System.out.println( "Success!" );
            }
        }// forever
    }//main
}//class MainApp
