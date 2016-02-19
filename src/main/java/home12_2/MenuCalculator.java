package home12_2;

/**
 * Contains all of the operations.
 * Responsible for the showing menu, and choose an operation from the menu.
 */
public class MenuCalculator {
	private ConsoleInput input;
	private Calculator calculator;

	/** The array of operations. */
	private BaseOperation[] operations = new BaseOperation[6];

	/**
	 * Default constructor.
	 * @param input Input.
	 * @param calculator Calculator.
     */
	public MenuCalculator(ConsoleInput input, Calculator calculator) {
		this.input = input;
		this.calculator = calculator;
	}

	/**
	 * Print menu.
	 */
	public void show() {
		System.out.println("\nChoose your operation:");
		for (BaseOperation operation : this.operations) {
			if (operation != null) {
				System.out.println(operation.info());
			}
		}
		System.out.println(String.format("%s - %s.", 6, "exit"));
	}

	/**
	 * Execute the selected operation by key from the menu.
	 * @param key Key.
     */
	public void select(int key) {
		boolean invalid = true;
		do {
			try {
				if (key == 5) {
					this.operations[key].execute(this.input, this.calculator, true);
				} else {
					this.operations[key].execute(this.input, this.calculator, false);
				}
				invalid = false;
			} catch (Exception e) {
				System.out.println("ERROR.");
				invalid = false;
			}
		} while(invalid);
	}

	/**
	 * Return the range of the menu choices.
	 * @return Range.
     */
	public int[] getRange() {
		return new int[] {0, 1, 2, 3, 4, 5, 6};
	}

	/**
	 * Request for the first number.
	 * @param reUse Only for operation 'use last result'.
	 * @return First number.
     */
	public double askFirst(boolean reUse) {
		double first;
		if(reUse == false) {
			first = Integer.valueOf(input.ask("Please enter first number: "));
		} else {
			first = calculator.getResult();
		}

		return first;
	}

	/**
	 * Filling array of operations.
	 */
	public void fillOperations() {
		operations[0] = new BaseOperation("add") {
			@Override
			int getKey() {
				return 0;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				double first = askFirst(reUse);
				double second = Integer.valueOf(input.ask("Please enter second number: "));

				calculator.add(first, second);
				calculator.setLastOperation(this.getKey());
				System.out.println("Result: " + calculator.getResult());
			}
		};

		operations[1] = new BaseOperation("subtract") {
			@Override
			int getKey() {
				return 1;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				double first = askFirst(reUse);
				double second = Integer.valueOf(input.ask("Please enter second number: "));

				calculator.subtract(first, second);
				calculator.setLastOperation(this.getKey());
				System.out.println("Result: " + calculator.getResult());
			}
		};

		operations[2] = new BaseOperation("div") {
			@Override
			int getKey() {
				return 2;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				double first = askFirst(reUse);
				double second = Integer.valueOf(input.ask("Please enter second number: "));

				calculator.div(first, second);
				calculator.setLastOperation(this.getKey());
				System.out.println("Result: " + calculator.getResult());
			}
		};

		operations[3] = new BaseOperation("multiple") {
			@Override
			int getKey() {
				return 3;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				double first = askFirst(reUse);
				double second = Integer.valueOf(input.ask("Please enter second number: "));

				calculator.multiple(first, second);
				calculator.setLastOperation(this.getKey());
				System.out.println("Result: " + calculator.getResult());
			}
		};

		operations[4] = new BaseOperation("use last operation") {
			@Override
			int getKey() {
				return 4;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				operations[calculator.getLastOperation()].execute(input, calculator, reUse);
			}
		};

		operations[5] = new BaseOperation("use last result") {
			@Override
			int getKey() {
				return 5;
			}

			@Override
			void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
				// to do
				System.out.println("First number: " + calculator.getResult());
				int operationKey = input.ask("Please enter operation[0..4]: ", new int[] {0, 1, 2, 3, 4});

				for (int index = 0; index <= 4; index++) {
					if (operations[index] != null && operationKey == operations[index].getKey()) {
						operations[index].execute(input, calculator, reUse);
					}
				}
			}
		};
	}
}