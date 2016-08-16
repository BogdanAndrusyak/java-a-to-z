package andrusyak.templates;

abstract class TemplateAction {

	TemplateAction(String name) {
	}

	abstract void start();

	abstract void finish();

	public void work() {
		this.start();
		this.finish();
	}

	public static void main(String[] args) {
		new TemplateAction("name") {
			public void start() {
			}

			public void finish() {
			}
		};
	}
}