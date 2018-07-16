grammar F;

group
    : '[' expr ']'
    | '(' expr ')'
    ;

expr : atom '^' INT ;
atom : ID
     | INT
     ;

INT : [0-9]+ ;
ID  : [a-zA-Z]+ ;
WS  : [ \t\r\n]+ -> skip ;