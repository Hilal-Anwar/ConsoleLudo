package org.game.jcengine.core;



import org.game.jcengine.util.Point;
import org.game.jcengine.util.Text;

import static org.game.jcengine.util.Print.*;

class Rendering {
      private final Scene scene;
      Rendering(Scene scene){
          this.scene = scene;
      }
      void _render(){
            var combined_mesh=new StringBuilder();
            for (int i = 0; i <scene.getHeight() ; i++) {
                  for (int j = 0; j < scene.getWidth(); j++) {
                        var point=getValidPoint(j,i);
                        if (point!=null)
                              combined_mesh.append(point.getTextWithColor());
                        else combined_mesh.append(Text.getSpace());
                  }
                  combined_mesh.append('\n');
            }
            println(combined_mesh);
      }
      private Text getValidPoint(int x, int y){
            var entity=scene.getEntityHashMap();
            for(var a:entity){
                  var e=a.getEntity();
                  var p=new Point(x,y);
                  if (e.containsKey(p))
                        return e.get(p);
            }
            return null;
      }
}
