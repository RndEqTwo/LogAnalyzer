grammar JSON;

json: value;

value: object
     | array
     | primitive;

primitive: STRING
         | NUMBER
         | TRUE
         | FALSE
         | NULL;

object: '{' (pair (',' pair)*)? '}';
key: STRING;
pair: key ':' value;

array: '[' (value (',' value)*)? ']';

TRUE: 'true';
FALSE: 'false';
NULL: 'null';
STRING: '"' ~[\u0000-\u001F"]* '"';
NUMBER: '-'? INT ('.' [0-9]+)? EXP?;
fragment INT: '0' | [1-9] [0-9]*;
fragment EXP: [Ee] [+\-]? INT;
WS: [ \t\r\n]+ -> skip;
IGNORE : . -> skip;