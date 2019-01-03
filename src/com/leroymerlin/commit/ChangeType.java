package com.leroymerlin.commit;

/**
 * From https://github.com/commitizen/conventional-commit-types
 *
 * @author Damien Arrachequesne
 */
public enum ChangeType {

    FEAT("Feature", "A new feature"),
    FIX("Bug Fixe", "A bug fix"),
    DOCS("Documentation", "Documentation only changes"),
    STYLE("Styles", "Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"),
    REFACTOR("Code Refactoring", "A code change that neither fixes a bug nor adds a feature"),
    PERF("Performance Improvements", "A code change that improves performance"),
    TEST("Tests", "Adding missing tests or correcting existing tests"),
    BUILD("Builds", "Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)"),
    CI("Continuous Integrations", "Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)"),
    CHORE("Chores", "Other changes that don't modify src or test files"),
    REVERT("Reverts", "Reverts a previous commit");

    public final String title;
    public final String description;

    ChangeType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String label() {
        return this.title.toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.title, this.description);
    }
}
