package com.leroymerlin.commit;

import org.apache.commons.lang.WordUtils;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * @author Damien Arrachequesne <damien.arrachequesne@gmail.com>
 */
class CommitMessage {
    private static final int MAX_LINE_LENGTH = 72; // https://stackoverflow.com/a/2120040/5138796
    private final String content;

    CommitMessage(ChangeType changeType, String changeScope, String shortDescription, String longDescription,
                  String caveatsSummary, String impacts, String securityRules, String jiraTicketId, String howToTest,
                  String smartCommits) {
        this.content = buildContent(changeType, changeScope, shortDescription, longDescription, caveatsSummary,
                impacts, securityRules, jiraTicketId, howToTest, smartCommits);
    }

    private String buildContent(ChangeType changeType, String changeScope, String shortDescription, String longDescription,
                                String caveatsSummary, String impacts, String securityRules, String jiraTicketId, String howToTest,
                                String smartCommits) {
        StringBuilder builder = new StringBuilder();
        builder.append(changeType.label());
        if (isNotBlank(changeScope)) {
            builder
                    .append('(')
                    .append(changeScope)
                    .append(')');
        }
        builder
                .append(": ")
                .append(shortDescription)
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        builder.append("Ticket: ").append(jiraTicketId).append(System.lineSeparator());
        builder.append("Summary: ").append(WordUtils.wrap(longDescription, MAX_LINE_LENGTH)).append(System.lineSeparator());
        if (isNotBlank(caveatsSummary))
            builder.append("Caveat: ").append(caveatsSummary).append(System.lineSeparator());
        if (isNotBlank(impacts))
            builder.append("Impact: ").append(impacts).append(System.lineSeparator());
        if (isNotBlank(securityRules))
            builder.append("Security Rules: ").append(securityRules).append(System.lineSeparator());
        if (isNotBlank(howToTest))
            builder.append("Test: ").append(howToTest).append(System.lineSeparator());
        if (isNotBlank(smartCommits))
            builder.append(smartCommits).append(System.lineSeparator());


        return builder.toString();
    }

    @Override
    public String toString() {
        return content;
    }
}