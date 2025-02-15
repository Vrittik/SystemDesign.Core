package systemDesign.Core.DecoratorDesignPattern;

public class ExtraCheeseTopping extends ToppingDecorator{
	
	BasePizza basePizza;
	public ExtraCheeseTopping(BasePizza _basePizza)
	{
		basePizza = _basePizza;
	}
	
	@Override
	public int cost() {
		return basePizza.cost() + 10;
	}
}
