package de.jduwe.loganalyzer.jsonplugin.antlr;// Generated from C:/Users/jadu/IdeaProjects/JsonPlugin/src/main/antlr\JSON.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JSONLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STRING=10, CUSTOMSTRING=11, NUMBER=12, WS=13, IGNORE=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"STRING", "CUSTOMSTRING", "NUMBER", "INT", "EXP", "WS", "IGNORE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'null'", "'{'", "','", "'}'", "':'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "STRING", 
			"CUSTOMSTRING", "NUMBER", "WS", "IGNORE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JSONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000ev\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0005\t@\b\t\n\t\f\tC\t\t\u0001\t\u0001\t\u0001\n\u0005\nH\b\n\n\n"+
		"\f\nK\t\n\u0001\u000b\u0003\u000bN\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000bS\b\u000b\u000b\u000b\f\u000bT\u0003\u000bW\b\u000b"+
		"\u0001\u000b\u0003\u000bZ\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f_\b\f"+
		"\n\f\f\fb\t\f\u0003\fd\b\f\u0001\r\u0001\r\u0003\rh\b\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0004\u000em\b\u000e\u000b\u000e\f\u000en\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\u0000\u001b\u0000"+
		"\u001d\r\u001f\u000e\u0001\u0000\u0006\u0002\u0000\u0000\u001f\"\"\u0001"+
		"\u000009\u0001\u000019\u0002\u0000EEee\u0002\u0000++--\u0003\u0000\t\n"+
		"\r\r  }\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001"+
		"!\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005,\u0001"+
		"\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t3\u0001\u0000\u0000"+
		"\u0000\u000b5\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f"+
		"9\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000\u0000\u0013=\u0001"+
		"\u0000\u0000\u0000\u0015I\u0001\u0000\u0000\u0000\u0017M\u0001\u0000\u0000"+
		"\u0000\u0019c\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001d"+
		"l\u0001\u0000\u0000\u0000\u001fr\u0001\u0000\u0000\u0000!\"\u0005t\u0000"+
		"\u0000\"#\u0005r\u0000\u0000#$\u0005u\u0000\u0000$%\u0005e\u0000\u0000"+
		"%\u0002\u0001\u0000\u0000\u0000&\'\u0005f\u0000\u0000\'(\u0005a\u0000"+
		"\u0000()\u0005l\u0000\u0000)*\u0005s\u0000\u0000*+\u0005e\u0000\u0000"+
		"+\u0004\u0001\u0000\u0000\u0000,-\u0005n\u0000\u0000-.\u0005u\u0000\u0000"+
		"./\u0005l\u0000\u0000/0\u0005l\u0000\u00000\u0006\u0001\u0000\u0000\u0000"+
		"12\u0005{\u0000\u00002\b\u0001\u0000\u0000\u000034\u0005,\u0000\u0000"+
		"4\n\u0001\u0000\u0000\u000056\u0005}\u0000\u00006\f\u0001\u0000\u0000"+
		"\u000078\u0005:\u0000\u00008\u000e\u0001\u0000\u0000\u00009:\u0005[\u0000"+
		"\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0005]\u0000\u0000<\u0012\u0001"+
		"\u0000\u0000\u0000=A\u0005\"\u0000\u0000>@\b\u0000\u0000\u0000?>\u0001"+
		"\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000DE\u0005\"\u0000\u0000E\u0014\u0001\u0000\u0000\u0000FH\b\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0016\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LN\u0005-\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OV\u0003\u0019"+
		"\f\u0000PR\u0005.\u0000\u0000QS\u0007\u0001\u0000\u0000RQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000XZ\u0003\u001b\r\u0000"+
		"YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0018\u0001\u0000"+
		"\u0000\u0000[d\u00050\u0000\u0000\\`\u0007\u0002\u0000\u0000]_\u0007\u0001"+
		"\u0000\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000c[\u0001\u0000\u0000\u0000c\\\u0001\u0000\u0000"+
		"\u0000d\u001a\u0001\u0000\u0000\u0000eg\u0007\u0003\u0000\u0000fh\u0007"+
		"\u0004\u0000\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0003\u0019\f\u0000j\u001c\u0001\u0000\u0000"+
		"\u0000km\u0007\u0005\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pq\u0006\u000e\u0000\u0000q\u001e\u0001\u0000\u0000"+
		"\u0000rs\t\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0006\u000f\u0000"+
		"\u0000u \u0001\u0000\u0000\u0000\u000b\u0000AIMTVY`cgn\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}