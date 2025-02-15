package systemDesign.Core.DecoratorDesignPattern;

public class DecoratorDesignPattern {
	
	public static void main(String[] args)
	{
		// creating a margharita pizza with double cheeze and mushrroms
		BasePizza margharitaPizza = new MushroomToppings(new ExtraCheeseTopping(new ExtraCheeseTopping(new MargharitaPizza())));
		System.out.println("custom margarita pizza cost = " + margharitaPizza.cost());
		
		// creating a farmhouse pizza with extra cheese
		BasePizza farmhouse = new ExtraCheeseTopping(new FarmhousePizza());
		System.out.println("custom Farmhouse pizza cost = " + farmhouse.cost());
		
		// creating a plain veggie delight pizza
		BasePizza veggieDelight = new VeggieDelightPizza();
		System.out.println("Plain veggie delight pizza cost = " + veggieDelight.cost());
	}
}
