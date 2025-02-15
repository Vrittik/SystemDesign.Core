package systemDesign.Core.DecoratorDesignPattern;

public class MushroomToppings extends ToppingDecorator{
	
	BasePizza basePizza;
	public MushroomToppings(BasePizza _basePizza)
	{
		basePizza = _basePizza;
	}
	
	@Override
	public int cost() {
		return basePizza.cost() + 15;
	}
}