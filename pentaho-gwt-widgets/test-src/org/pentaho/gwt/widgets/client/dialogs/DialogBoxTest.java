/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2015 Pentaho Corporation..  All rights reserved.
*/

package org.pentaho.gwt.widgets.client.dialogs;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

@RunWith( GwtMockitoTestRunner.class )
@SuppressWarnings( "deprecation" )
public class DialogBoxTest {
  @Test
  public void testOnKeyDownPreview() throws Exception {
    DialogBox box = mock( DialogBox.class );
    doCallRealMethod().when( box ).onKeyDownPreview( anyChar(), anyInt() );

    box.onKeyDownPreview( (char) KeyboardListener.KEY_ENTER, 0 );
    box.onKeyDownPreview( (char) KeyboardListener.KEY_ESCAPE, 0 );

    verify( box, times( 2 ) ).hide();
  }

  @Test
  public void testSetFocusWidget() throws Exception {
    DialogBox box = mock( DialogBox.class );
    doCallRealMethod().when( box ).setFocusWidget( any( FocusWidget.class ) );

    final FocusWidget focusWidget = mock( FocusWidget.class );
    box.setFocusWidget( focusWidget );
    verify( focusWidget ).setFocus( true );
  }
}