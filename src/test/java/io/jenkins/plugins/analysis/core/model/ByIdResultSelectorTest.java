package io.jenkins.plugins.analysis.core.model;

import java.util.ArrayList;
import java.util.Collections;
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

    String id = "1";

    @Test
    void testNoActions() {
        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(Collections.EMPTY_LIST);
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector(id);
        Optional<ResultAction> actualResult = byIdResultSelector.get(run);
        assertThat(actualResult).isEmpty();
    }

   /* @Test
    void test1() {
        ResultAction resultAction = mock(ResultAction.class);
        List<ResultAction> resAct = new ArrayList<>();
        resAct.add(resultAction);

        Run<?, ?> run = mock(Run.class);
        when(run.getActions(ResultAction.class)).thenReturn(resAct);

        when(resultAction.getId()).thenReturn(id);
        ByIdResultSelector byIdResultSelector = new ByIdResultSelector(id);
        Optional<ResultAction> actualResult = byIdResultSelector.get(run);
        //assertThat(actualResult).is(resultAction);
    }*/

}