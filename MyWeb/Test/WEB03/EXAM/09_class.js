class FruitManager{
    constructor(){
        this.fruits = [
            {name: "apple", price: 1000},
            {name: "banana", price: 2000},
            {name: "orange", price: 3000},
            {name: "grape", price: 4000},
            {name: "kiwi", price: 5000}
        ];
    }


addFruit(name, price){
    this.fruits.push({name, price});
}

printFruits(){
    this.fruits.forEach((fruit) => {
        console.log(`${fruit.name}: ${fruit.price}`);
    });
    }
}


const manager = new FruitManager();
manager.printFruits();

manager.addFruit("peach", 6000);
manager.printFruits();
