grammar JSON;

//json: value;

json: value ;

value: object
    | array
    | STRING
    | NUMBER
    | 'true'
    | 'false'
    | 'null';

object: '{' (pair (',' pair)*)? '}';
key: STRING;
pair: key ':' value;

array: '[' (value (',' value)*)? ']';

STRING: '"' ~[\u0000-\u001F"]* '"';
NUMBER: '-'? INT ('.' [0-9]+)? EXP?;
fragment INT: '0' | [1-9] [0-9]*;
fragment EXP: [Ee] [+\-]? INT;
WS: [ \t\r\n]+ -> skip;
IGNORE : . -> skip;