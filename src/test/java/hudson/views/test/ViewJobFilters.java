package hudson.views.test;

import hudson.model.Descriptor;
import hudson.model.TopLevelItemDescriptor;
import hudson.scm.SCMDescriptor;
import hudson.views.*;

import static hudson.views.AbstractBuildTrendFilter.AmountType.Builds;
import static hudson.views.AbstractBuildTrendFilter.BuildCountType.All;
import static hudson.views.AbstractIncludeExcludeJobFilter.IncludeExcludeType.includeMatched;

public class ViewJobFilters {

    public static RegExJobFilter nameRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.NAME.name());
    }

    public static RegExJobFilter descRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.DESCRIPTION.name());
    }

    public static RegExJobFilter emailRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.EMAIL.name());
    }

    public static RegExJobFilter scheduleRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.SCHEDULE.name());
    }

    public static RegExJobFilter scmRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.SCM.name());
    }

    public static RegExJobFilter mavenRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.MAVEN.name());
    }

    public static RegExJobFilter nodeRegex(String regex) {
        return new RegExJobFilter(
                regex,
                includeMatched.name(),
                RegExJobFilter.ValueType.NODE.name());
    }


    public static BuildStatusFilter buildStatus(
            boolean neverBuild,
            boolean building,
            boolean inBuildQueue) {
        return new BuildStatusFilter(
                neverBuild,
                building,
                inBuildQueue,
                includeMatched.name());
    }

    public static JobStatusFilter jobStatus(
            boolean unstable,
			boolean failed,
            boolean aborted,
            boolean disabled,
            boolean stable) {
        return new JobStatusFilter(
                unstable,
                failed,
                aborted,
                disabled,
                stable,
                includeMatched.name());
    }

    public static JobTypeFilter jobType(TopLevelItemDescriptor descriptor) {
        return jobType(descriptor.getId());
    }

    public static JobTypeFilter jobType(String type) {
        return new JobTypeFilter(
                type,
                includeMatched.name());
    }

    public static ScmTypeFilter scmType(String type) {
        return new ScmTypeFilter(type, includeMatched.name());
    }

    public static SecurityFilter security(
            String permissionCheckType,
            boolean configure,
            boolean build,
            boolean workspace) {
        return new SecurityFilter(
                permissionCheckType,
                configure,
                build,
                workspace,
                includeMatched.name());
    }

    public static SecuredJobsFilter secured() {
        return new SecuredJobsFilter(includeMatched.name());
    }

    public static ScmTypeFilter scmType(SCMDescriptor<?> descriptor) {
        return scmType(descriptor.clazz.getName());
    }

    public static BuildDurationFilter buildDuration(float minutes, String lessThan) {
        return new BuildDurationFilter(minutes, "<".equals(lessThan),
            All.name(), 0, Builds.name(), includeMatched.name());
    }

    public static BuildTrendFilter buildTrend(BuildTrendFilter.StatusType statusType) {
        return new BuildTrendFilter(All.name(), statusType.name(), 0, Builds.name(), includeMatched.name());
    }
}
