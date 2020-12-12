/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.Color;
import javax.swing.text.DefaultHighlighter;


public class myHighlighter extends DefaultHighlighter.DefaultHighlightPainter{
    
    public myHighlighter(Color color){
        super(color);
    }
    
    
    
}
