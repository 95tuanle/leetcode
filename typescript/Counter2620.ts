const createCounter = (n: number): () => number => () => n++;

const counter2620 = createCounter(2620);
console.log(counter2620()); // 2620
console.log(counter2620()); // 2621
console.log(counter2620()); // 2622
console.log(counter2620()); // 2623
