/*
 * @topic T10173 Desktop Calculator v3
 * @brief class AstNode represents a building block for AST, the abstract syntax tree
*/
package wk03_calc_v3;

import java.util.HashMap;

public class AstNode {
    //---------------------------
    // constants
    //---------------------------
    public static final int NUMBER = 'N';
    public static final int END = 'Z';
    public static final int ERROR = 'E';
    public static final int IDENTIFIER = 'I';
    
    //---------------------------
    // data
    //---------------------------
    static public HashMap<String, Double> symbolTable = new HashMap<>();
    public int type;
    public String value;
    public AstNode leftNode;
    public AstNode rightNode;

    //---------------------------
    // constructors
    //---------------------------
    public AstNode(int type) {
        this.type = type;
        this.value = "";
        this.leftNode = null;
        this.rightNode = null;
    }//AstNode

    public AstNode(int type, String value) {
        this.type = type;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }//AstNode

    //---------------------------
    // operations
    //---------------------------
    public void print( int level ) {
        for ( int idx = 0; idx < level; ++idx ) System.out.print( "." );
//        System.out.println( value );
//
//        if ( leftNode != null ) leftNode.print( level + 1 );
//        if ( rightNode != null ) rightNode.print( level + 1 );

        if ( leftNode != null && rightNode != null ) {
                System.out.println("Answer: " + evaluate());

        }
    }//print

    public double evaluate(){

        if(value.matches("[-+]?\\d*\\.?\\d+")){
            return Double.parseDouble(value);
        }

        switch ( type ) {

            case IDENTIFIER:
                if ( symbolTable.containsKey( value ) ) {
                    return symbolTable.get( value );
                }
                System.out.println("\n Undefined variable "+value );
                break;

            case '=':
            {
                double rightValue = rightNode.evaluate();
                symbolTable.put( leftNode.value, rightValue );
                return rightValue;
            }
            case  '-'  :
                if (leftNode == null){
                    return -rightNode.evaluate();
                }
                else if (rightNode == null){
                    return -leftNode.evaluate();
                }
                else {
                    return leftNode.evaluate() - rightNode.evaluate();
                }
            case '+':
                return leftNode.evaluate() + rightNode.evaluate();
            case '*':
                return leftNode.evaluate() * rightNode.evaluate();
            case '/':
                return leftNode.evaluate() / rightNode.evaluate();
            case  '%':
                return leftNode.evaluate() % rightNode.evaluate();
        }


        return 0;

    }//evaluate

}//class AstNode
