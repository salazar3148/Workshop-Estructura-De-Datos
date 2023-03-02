import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> etiquetas = new Stack<>();

		while(!tags.isEmpty()){

			HtmlTag tag = tags.remove();

			if(tag.isSelfClosing()) continue;

			if(tag.isOpenTag()) etiquetas.push(tag);
			else {
				if(etiquetas.isEmpty()) return null;
				if(etiquetas.peek().matches(tag)) etiquetas.pop();
				else return etiquetas;
			}
		}
		return etiquetas; // this line is here only so this code will compile if you don't modify it
	}
}

