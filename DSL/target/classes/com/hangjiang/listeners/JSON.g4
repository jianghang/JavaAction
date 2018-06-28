grammar JSON;

json : object
     | array
     ;

object
     : '{' pair (',' pair)* '}'     # AnObject
     | '{' '}'                      # EmptyObject
     ;
pair : STRING ':' value;

array
     : '[' value (',' value)* ']'   # ArrayOfValues
     | '[' ']'                      # EmptyArray
     ;

value
     : STRING       # String
     | NUMBER       # Atom
     | object       # ObjectValue
     | array        # ArrayValue
     | 'true'       # Atom
     | 'false'      # Atom
     | 'null'       # Atom
     ;

STRING : '"' (ESC | ~["\\])* '"';
fragment ESC : '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX :  [0-9a-fA-F] ;

NUMBER
     : '-'? INT '.' INT EXP? //1.35, 1.35E-9, 0.3, -4.5
     | '-'? INT EXP //1e10, -3e4
     | '-'? INT // -3, 45
     ;
fragment INT : '0' | [1-9] [0-9]* ;//除0外的数字不允许以0开始
fragment EXP : [Ee] [+\-]? INT ;//\- 是对 - 转义，因为[...]中的-用于表达"范围"语义

WS : [ \t\n\r]+ -> skip;