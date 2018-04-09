package io.jenkins.plugins.analysis.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import io.jenkins.plugins.analysis.core.views.ResultAction;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import hudson.model.Run;

/**
 * Tests the class {@link ByIdResultSelector}.
 *
 * @author Anna-Maria Hardi
 */
class ByIdResultSelectorTest {

    @Test
    void testShouldEmptyIfActionsAreEmpty() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("1");

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(new ArrayList<>());

        Optional<ResultAction> actualResult = byIdResultSelector.get(run);
        assertThat(actualResult).isEmpty();
    }

    @Test
    void testOneShouldEmptyIfIdsAreDifferent() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("1");

        ResultAction resultAction = mock(ResultAction.class);
        when(resultAction.getId()).thenReturn("2");

        List<ResultAction> resAct = new ArrayList<>();
        resAct.add(resultAction);

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(resAct);

        assertThat(byIdResultSelector.get(run)).isEmpty();
    }

    @Test
    void testTwoShouldEmptyIfIdsAreDifferent() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("2");

        ResultAction resultAction = mock(ResultAction.class);
        when(resultAction.getId()).thenReturn("3");

        List<ResultAction> resAct = new ArrayList<>();
        resAct.add(resultAction);

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(resAct);

        assertThat(byIdResultSelector.get(run)).isEmpty();
    }

    @Test
    void testThreeShouldEmptyIfIdsAreDifferent() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("2");

        ResultAction resultAction = mock(ResultAction.class);
        when(resultAction.getId()).thenReturn("1");

        List<ResultAction> resAct = new ArrayList<>();
        resAct.add(resultAction);

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(resAct);

        assertThat(byIdResultSelector.get(run)).isEmpty();
    }


    @Test
    void testShouldFindSameIds() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("1");

        ResultAction resultAction = mock(ResultAction.class);
        when(resultAction.getId()).thenReturn("1");

        List<ResultAction> resAct = new ArrayList<>();
        resAct.add(resultAction);

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(resAct);

        assertThat(byIdResultSelector.get(run)).isPresent();
    }

    @Test
    void testToString() {
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector("1");

        assertThat(byIdResultSelector.toString()).isEqualTo("io.jenkins.plugins.analysis.core.views.ResultAction with ID 1");
    }

}