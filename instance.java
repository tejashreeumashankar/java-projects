/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // Edge case: If the classFunction is not a function or is null/undefined, it's invalid
    if (classFunction === null || classFunction === undefined || typeof classFunction !== 'function') {
        return false;
    }
    
    // Edge case: If the object is null or undefined, it cannot be an instance of any class
    if (obj === null || obj === undefined) {
        return false;
    }

    // Get the initial prototype of the object
    // Object(obj) handles primitive values like numbers or booleans so we can check their prototypes
    let currentPrototype = Object.getPrototypeOf(Object(obj));

    // Traverse up the prototype chain
    while (currentPrototype !== null) {
        // If we find a match with the class's prototype, return true
        if (currentPrototype === classFunction.prototype) {
            return true;
        }
        // Move to the next prototype up the chain
        currentPrototype = Object.getPrototypeOf(currentPrototype);
    }

    // If we reached the end of the chain without a match
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */