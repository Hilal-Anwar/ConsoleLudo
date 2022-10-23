module org.game{
    requires org.jline;
    requires org.fusesource.jansi;
    requires com.sun.jna;

    opens org.game.jcengine.core;
}