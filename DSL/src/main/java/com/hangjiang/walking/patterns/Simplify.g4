grammar Simplify;

prog : stat+;
stat : ID '=' expr
     | 'print' expr
     ;

expr : multExpr ('+' multExpr)* ;
multExpr
    : primary (('*' | '.') primary)*
    ;
primary
    : INT
    | ID
    | '[' expr (',' expr)* ']'
    | '(' expr ')'
    ;

ID : [a-z]+ ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip;