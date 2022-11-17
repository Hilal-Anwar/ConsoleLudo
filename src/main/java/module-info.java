module org.game{
    requires org.jline;
    requires org.fusesource.jansi;
    requires com.sun.jna;
    requires java.desktop;

    opens org.game.jcengine.core;
}