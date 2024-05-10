package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  TorpedoStore t1;
  TorpedoStore t2;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    t1 = mock(TorpedoStore.class);
    t2 = mock(TorpedoStore.class);
    this.ship = new GT4500(t1, t2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(t1.isEmpty()).thenReturn(false);
    when(t1.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(t1.isEmpty() && t2.isEmpty()).thenReturn(false);
    when(t1.fire(1) || t2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
