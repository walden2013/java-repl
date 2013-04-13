package javarepl.expressions;

import com.googlecode.totallylazy.Function1;

public abstract class Expression {
    private final String source;

    protected Expression(String source) {
        this.source = source;
    }

    public String source() {
        return source;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + source + ")";
    }

    @Override
    public int hashCode() {
        return (source != null ? source.hashCode() : 0);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Expression &&
                other.getClass().equals(getClass()) &&
                (source != null && source.equals(((Expression) other).source));
    }

    public static enum functions{;
        public static Function1<Expression, String> source() {
            return new Function1<Expression, String>() {
                public String call(Expression value) throws Exception {
                    return value.source;
                }
            };
        }
    }



}