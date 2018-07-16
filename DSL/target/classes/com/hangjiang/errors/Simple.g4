grammar Simple;

prog : classDef+ ;

classDef
     : 'class' ID '{' member+ '}'
       {System.out.println("class " + $ID.text);}
     ;

member
     : 'int' ID ';'//字段定义
       {System.out.println("var " + $ID.text);}
     | 'int' f=ID '(' ID ')' '{' stat '}'//方法定义
       {System.out.println("method: " + $f.text);}
     ;

stat : expr ';'
       {System.out.println("found expr: " + $ctx.getText());}
     | ID '=' expr ';'
       {System.out.println("found assign: " + $ctx.getText());}
     ;

expr : INT
     | ID '(' INT ')'
     ;

INT  : [0-9]+ ;
ID   : [a-zA-Z]+ ;
WS   : [ \t\r\n]+ -> skip;